package com.dao;

import com.bean.Book;
import com.util.DB;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO {

    private String sql="";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Book> books = new ArrayList<Book>();
    private Book book;
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
    public ArrayList<Book> getAll(){
        sql = "select * from book";
        try{
            pstmt = getConn().prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRs(rs);
    }

    public ArrayList<Book> getByRs(ResultSet rs) {
        try{
            if(rs==null || !rs.next())
                return null;
            books.clear();
            do{
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setPubdate(rs.getString("pubdate"));
                book.setPrice(rs.getFloat("price"));
                book.setIsbn(rs.getString("isbn"));
                books.add(book);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Book> getByName(String bookname){
        getConn();
        if(bookname==null)
            bookname = "";
        try{
            CallableStatement cs = conn.prepareCall("call getByNameProc(?)");
            cs.setString(1,bookname);
            rs = cs.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRs(rs);
    }


    public Book getById(int id){
        getConn();
        sql = "select * from book where id=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRs(rs).get(0);
    }

    public boolean updateBook(Book book){
        sql = "update book set bookname=?,author=?,press=?,pubdate=?,price=?,isbn=? where id=?";
        int result = 0;
        try{
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1,book.getBookname());
            pstmt.setString(2,book.getAuthor());
            pstmt.setString(3,book.getPress());
            pstmt.setString(4,book.getPubdate());
            pstmt.setFloat(5,book.getPrice());
            pstmt.setString(6,book.getIsbn());
            pstmt.setInt(7,book.getId());
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
        if(result>0)
            return true;
        else
            return false;
    }

    public boolean delete(int id){
        sql = "delete from book where id=?";
        int result = 0;
        try{
            pstmt = getConn().prepareStatement(sql);
            pstmt.setInt(1,id);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
        if(result > 0)
            return true;
        else
            return false;
    }

    public boolean add(Book book){
        sql = "INSERT INTO book (bookname, author, press, pubdate, price, isbn) VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
        int result = 0;
        try{
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1,book.getBookname());
            pstmt.setString(2,book.getAuthor());
            pstmt.setString(3,book.getPress());
            pstmt.setString(4,book.getPubdate());
            pstmt.setFloat(5,book.getPrice());
            pstmt.setString(6,book.getIsbn());
            result = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        if(result > 0)
            return true;
        else
            return false;
    }

    public void close(){
        try {
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
                pstmt.close();
            if(conn!=null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs = null;
            pstmt = null;
            conn = null;
        }
    }
}
