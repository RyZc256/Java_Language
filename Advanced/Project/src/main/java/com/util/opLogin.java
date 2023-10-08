package com.util;

import com.entity.Student;
import com.entity.Teacher;
import com.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class opLogin implements InterfaceLogin {

    private DBManger db;
    private InterfaceRegular interfaceRegular;


    public opLogin(){
        db = new DBManger();
        interfaceRegular = new Regular();
    }

    @Override
    public boolean login(User user,String password) {
        return false;
    }

    @Override
    public User selectUser(String account) {
        String role = interfaceRegular.account(account);
        String sql = String.format("SELECT * FROM %s WHERE Account=?;",role);
        User user = null;
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,Integer.parseInt(account));
            ResultSet rs = pstms.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    // 账号类型是教师
                    if (role.equals("teacher"))
                        user = new Teacher(rs.getInt("Account"),
                                rs.getString("Password"),
                                rs.getString("Name"),
                                rs.getString("Sex"),
                                rs.getInt("Age"),
                                rs.getString("IdCard"),
                                rs.getString("Telphone"),
                                rs.getString("Image"),
                                rs.getString("College"),
                                rs.getString("LastOnline"),
                                rs.getInt("Enable"),
                                role,
                                rs.getString("Class"));
                    // 账号类型是学生
                    else
                        user = new Student(rs.getInt("Account"),
                                rs.getString("Password"),
                                rs.getString("Name"),
                                rs.getString("Sex"),
                                rs.getInt("Age"),
                                rs.getString("IdCard"),
                                rs.getString("Telphone"),
                                rs.getString("Image"),
                                rs.getString("College"),
                                rs.getString("Class"),
                                rs.getString("LastOnline"),
                                role);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean reset(User user) {
        int result = 0;
        String sql = String.format("UPDATE %S SET Password = ? WHERE Account = ? AND IdCard = ?;",user.getRole());
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,user.getPassword());
            pstms.setInt(2,user.getAccount());
            pstms.setString(3,user.getIdCard());
            result = pstms.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean upDateLastOnline(User user) {
        int result = 0;
        String sql = String.format("UPDATE %s SET LastOnline = ? WHERE Account = ?;",user.getRole());
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,new Datetime().now());
            pstms.setInt(2,user.getAccount());
            result = pstms.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result!=0)
            return true;
        else
            return false;
    }

}
