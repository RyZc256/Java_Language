package com.entity;

import com.util.DBManager;

import java.sql.ResultSet;


public class User {
    private int U_ID;
    private String U_Account;
    private String U_Password;
    private String U_Email;
    private String U_Idcard;
    private String U_Telphone;
    private String U_CreateTime;
    private String U_LastOnline;


    /**
     * 构造函数
     * @param u_Account 用户名
     */
    public User(String u_Account){
        init(u_Account);
    }

    /**
     * 构造函数
     * @param account 用户名
     * @param password 密码
     * @param email 邮件地址
     * @param idcard 身份证
     * @param telphone 联系电话
     */
    public User(String account,String password,String email,String idcard,String telphone){
        setU_Account(account);
        setU_Password(password);
        setU_Email(email);
        setU_Idcard(idcard);
        setU_Telphone(telphone);

    }

    public User() {

    }


    /**
     * 初始化用户实体类
     * @param u_Account 用户名
     * @return true 初始化成功 false 初始化失败
     */
    public boolean init(String u_Account){
        DBManager db = new DBManager();
        int flag = 0;
        // 查询用户的所有信息

        String sql = String.format("select * from user where U_Account = \"%s\"",u_Account);
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                U_Password = rs.getString("U_Password");
                U_ID = rs.getInt("U_ID");
                U_Account = rs.getString("U_Account");
            }
            rs.close();
            flag++;
        }catch (Exception e){
            e.printStackTrace();
        }

        sql = String.format("select * from userinfo where U_ID = \"%s\"",getU_ID());
        rs = db.query(sql);
        try{
            while(rs.next()){
                U_Email = rs.getString("U_Email");
                U_Idcard = rs.getString("U_IdCard");
                U_Telphone = rs.getString("U_Telphone");
                U_Telphone = rs.getString("U_CreateTime");
                U_LastOnline = rs.getString("U_LastOnline");
            }
            rs.close();
            flag++;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag == 2;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getU_Account() {
        return U_Account;
    }

    public void setU_Account(String u_Account) {
        U_Account = u_Account;
    }

    public String getU_Password() {
        return U_Password;
    }

    public void setU_Password(String u_Password) {
        U_Password = u_Password;
    }

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }

    public String getU_Idcard() {
        return U_Idcard;
    }

    public void setU_Idcard(String u_Idcard) {
        U_Idcard = u_Idcard;
    }

    public String getU_Telphone() {
        return U_Telphone;
    }

    public void setU_Telphone(String u_Telphone) {
        U_Telphone = u_Telphone;
    }

    public String getU_CreateTime() {
        return U_CreateTime;
    }

    public void setU_CreateTime(String u_CreateTime) {
        U_CreateTime = u_CreateTime;
    }

    public String getU_LastOnline() {
        return U_LastOnline;
    }

    public void setU_LastOnline(String u_LastOnline) {
        U_LastOnline = u_LastOnline;
    }

    @Override
    public String toString() {
        return "User{" +
                "U_ID=" + U_ID +
                ", U_Account='" + U_Account + '\'' +
                ", U_Password='" + U_Password + '\'' +
                ", U_Email='" + U_Email + '\'' +
                ", U_Idcard='" + U_Idcard + '\'' +
                ", U_Telphone='" + U_Telphone + '\'' +
                ", U_CreateTime='" + U_CreateTime + '\'' +
                ", U_LastOnline='" + U_LastOnline + '\'' +
                '}';
    }
}
