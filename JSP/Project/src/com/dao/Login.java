package com.dao;

import com.entity.*;
import com.util.DBManager;
import com.util.Date;
import com.util.EmailSend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    DBManager db;
    Date date;

    /**
     * 构造函数
     */
    public Login(){
        db = new DBManager();
        db.init();
        date = new Date();
    }

    /**
     * 登录
     * @param username 账户名
     * @param password 密码
     * @return null 登录成功 否则返回错误信息
     */
    public String login(String username,String password){
        boolean result = false;
        //用户id
        int id = 0;
        String sql = String.format("SELECT * FROM user WHERE U_Account=\"%s\"",username);
        ResultSet rs = db.query(sql);
        // 查看是否有记录返回，如若没有说明帐号密码错误
        try{
            if(rs==null || !rs.next())
                return "账号不存在";
            id = Integer.parseInt(rs.getString("U_ID"));
            if(!password.equals(rs.getString("U_Password")))
                return "账号或密码错误";
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        // 获取当前时间
        String now = date.now();

        // 设置帐号状态以及最后登录时间

        sql = String.format("UPDATE userinfo SET U_LastOnline=\"%s\" WHERE U_ID=\"%s\" ",now,id);
        if(!db.update(sql))
        {
            return "那说不定";
        }
        return null;
    }


    /**
     * 注册帐号
     * @param user 注册用户实体类
     * @return null 注册成功 否则返回错误信息
     */
    public String register(User user){
        // 如果参数不够
        if(!check_Integrity(user))
            return "数据不完整";
        // 帐号已被注册
        if(check(user.getU_Account(),"U_Account"))
            return "账号已被注册";
        // 邮箱已被注册
        if(check(user.getU_Email(),"U_Email"))
            return "邮箱已被注册";
        // 身份证已被注册
        if(check(user.getU_Idcard(),"U_IdCard"))
            return "身份证已被注册";
        // 电话已被注册
        if(check(user.getU_Telphone(),"U_Telphone"))
            return "电话已被注册";
        // 获取当前时间，作为帐号创建时间与最后登录时间
        String sql = String.format("INSERT INTO user (U_Account,U_Password)VALUES(\"%s\",\"%s\");",user.getU_Account(),user.getU_Password());

        // 用户表
        if (db.update(sql)){
            sql = String.format("SELECT * FROM user WHERE U_Account=\"%s\" AND U_Password=\"%s\"",user.getU_Account(),user.getU_Password());
            ResultSet rs = db.query(sql);

            // 获取用户ID
            try{
                while(rs.next())
                    user.setU_ID(Integer.parseInt(rs.getString("U_ID")));
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            // 用户信息表
            String now = date.now();
            sql = String.format("INSERT INTO userinfo (U_ID,U_EMail,U_IdCard,U_Telphone,U_CreateTime,U_LastOnline)VALUES(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",user.getU_ID(),user.getU_Email(),user.getU_Idcard(),user.getU_Telphone(),now,now);
            if(db.update(sql)){
                // 完善实体类
                user.setU_CreateTime(now);
                user.setU_LastOnline(now);
                // 注册成功,发送注册邮件
                EmailSend es = new EmailSend(user.getU_Email());
                es.register(user.getU_Account());
            }
            return null;
        }else
            return "注册失败，请稍后重试";
    }

    /**
     * 找回密码
     * @param user 用户实体类
     * @return String 返回验证码
     */
    public String retrieve(User user){
        String result = "";

        String sql = String.format("SELECT * FROM userinfo WHERE U_ID=\"%S\"",user.getU_ID());
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                if(rs.getString(0)!=null){
                    user.setU_Email(rs.getString(3));
                    EmailSend es = new EmailSend(user.getU_Email());
                    result = es.retrieve(user);
                }
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检查指定字段是否重复注册
     * @param data 查重的数据
     * @param field 指定字段
     * @return true 帐号已被注册 false 帐号未被注册
     */
    public boolean check(String data,String field){
        boolean result = false;
        String sql = String.format("SELECT * FROM userinfo WHERE %s =\"%s\"",field,data);
        if(field.equals("U_Account")){
            sql = String.format("SELECT * FROM user WHERE %s =\"%s\"",field,data);
        }

        ResultSet rs = db.query(sql);
        try {
            while(rs.next())
                // 如果返回值不为空表明帐号已被注册
                if(rs.getString(1)!=null)
                    result = true;
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检查实体类完整性
     * @return true 实体类完整 false 实体类不完整
     */
    public boolean check_Integrity(User user){
        return  (user.getU_Account() != null && user.getU_Password()!=null && user.getU_Email()!=null && user.getU_Idcard() != null && user.getU_Telphone() != null);
    }
}
