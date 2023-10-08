package com.util;

import com.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infortmation implements InterfaceInformation {

    private DBManger db;
    private PreparedStatement pstms;
    private ResultSet rs;

    public Infortmation(){
        db = new DBManger();
    }

    @Override
    public ArrayList<String> getAllClass(String college) {
        ArrayList<String> result = new ArrayList<>();
        String sql = "SELECT * FROM class WHERE College=?;";
        try{
            pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,college);
            rs = pstms.executeQuery();
            if(rs!=null){
                while(rs.next())
                    result.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<String> getAllCollege() {
        ArrayList<String> result = new ArrayList<>();
        String sql = "SELECT * FROM college;";
        try{
            pstms = db.getConn().prepareStatement(sql);
            rs = pstms.executeQuery();
            if(rs!=null){
                while(rs.next())
                    result.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean upDatePhoto(User user) {
        int result = 0;
        String sql = String.format("UPDATE %S SET Image = ? WHERE Account = ?;",user.getRole());
        try{
            pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,user.getImage());
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

    @Override
    public boolean upDateInformation(User user) {
        int result = 0;
        String sql = String.format("UPDATE %s SET Name=?,Sex=?,Age=?,IdCard=?,Telphone=?,College=?,Class=? WHERE Account=?;",user.getRole());
        try{
            pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,user.getName());
            pstms.setString(2,user.getSex());
            pstms.setInt(3,user.getAge());
            pstms.setString(4,user.getIdCard());
            pstms.setString(5,user.getTelphone());
            pstms.setString(6,user.getCollege());
            pstms.setString(7,user.getsClass());
            pstms.setInt(8,user.getAccount());
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
    public User singleAddStu(User user) {
        String sql = "INSERT INTO student(Password,Name,Sex,Age,IdCard,Telphone,College,Class) VALUES(?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,user.getPassword());
            pstms.setString(2,user.getName());
            pstms.setString(3,user.getSex());
            pstms.setInt(4,user.getAge());
            pstms.setString(5,user.getIdCard());
            pstms.setString(6,user.getTelphone());
            pstms.setString(7,user.getCollege());
            pstms.setString(8,user.getsClass());
            if(pstms.executeUpdate()!=0){
                String select = "SELECT * FROM student WHERE Name=? AND IdCard=?;";
                pstms = db.getConn().prepareStatement(select);
                pstms.setString(1,user.getName());
                pstms.setString(2,user.getIdCard());
                ResultSet rs = pstms.executeQuery();
                while(rs.next()){
                    user.setAccount(rs.getInt("Account"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delStu(User user) {
        int result = 0;
        String sql = "DELETE FROM student WHERE Account=?";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,user.getAccount());
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
