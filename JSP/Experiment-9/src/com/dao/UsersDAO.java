package com.dao;

import com.bean.Book;
import com.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {

    private String sql="";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Connection conn = null;

    private Connection getConn(){
        try{
            if((conn==null)||conn.isClosed()){
                DB db = new DB();
                conn = db.getConn();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public boolean login(String user,String password){
        boolean result = false;
        String search = "";
        getConn();
        String sql = "select * from user where username=? and password=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            while(rs.next())
                search = rs.getString("username");
            if(search != "")
                result = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}

