package com.util;

import com.entity.Student;
import com.entity.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class opRegister implements InterfaceRegister {

    private DBManger db;

    public opRegister(){
        db = new DBManger();
    }

    @Override
    public boolean Register(Student student) {
        return false;
    }

    @Override
    public String Register(Teacher teacher) {
        try{
            // 检查SQL语句
            String selectSql = "SELECT * FROM teacher WHERE Account=? or IdCard=?;";
            PreparedStatement pstms = db.getConn().prepareStatement(selectSql);
            // 设置参数
            pstms.setInt(1,teacher.getAccount());
            pstms.setString(2,teacher.getIdCard());
            // 执行SQL语句
            ResultSet rs = pstms.executeQuery();
            while(rs.next()){
                if(rs.getInt("Account")==teacher.getAccount())
                    return "用户名重复";
                if(rs.getString("IdCard").equals(teacher.getIdCard()))
                    return "身份证重复";
            }
            // 插入SQL语句
            String insertSql = "INSERT INTO teacher (Account, Password, Name, Sex, Age, IdCard, Telphone, College, LastOnline) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pstms = db.getConn().prepareStatement(insertSql);
            pstms.setInt(1,teacher.getAccount());
            pstms.setString(2,teacher.getPassword());
            pstms.setString(3,teacher.getName());
            pstms.setString(4,teacher.getSex());
            pstms.setInt(5,teacher.getAge());
            pstms.setString(6,teacher.getIdCard());
            pstms.setString(7,teacher.getTelphone());
            pstms.setString(8,teacher.getCollege());
            pstms.setString(9,new Datetime().now());
            // 执行SQL语句
            if(pstms.executeUpdate()==1)
                return "注册成功，等待信息中心老师审核通过";
            else
                return "注册失败，请重新尝试";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String> SelectCollege() {
        // SQL语句
        String sql = "SELECT * FROM college";
        ArrayList<String> result = new ArrayList<>();
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            ResultSet rs = pstms.executeQuery();
            while(rs.next()) {
                // 添加到ArrayList中
                result.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
