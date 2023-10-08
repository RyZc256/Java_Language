package com;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Experiment_2 {

    private String driver;
    private String url;
    private String username;
    private String password;
    private java.sql.Connection conn;

    public static void main(String[] args) {

        Experiment_2 e2= new Experiment_2();
        e2.init();
        Statement stmt;

        String sql = "SELECT * FROM tb_emp LIMIT 3 OFFSET 1;";
        try{
            stmt = e2.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.print("编号"+rs.getString("id"));
                System.out.print("姓名"+rs.getString("name"));
                System.out.print("性别"+rs.getString("sex"));
                System.out.print("出生日期"+rs.getString("birth"));
                System.out.print("部门"+rs.getString("dept"));
                System.out.println("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean init(){
        try{
            // 读取指定文件内容
            Properties p = new Properties();
            InputStream is = this.getClass().getResourceAsStream("./config.ini");
            p.load(is);

            // 拆分文件内的参数
            setDriver(p.getProperty("driver"));
            setUrl(p.getProperty("url"));
            setUsername(p.getProperty("username"));
            setPassword(p.getProperty("password"));

            // 数据库驱动
            Class.forName(getDriver());

            // 设置数据库参数
            setConn(DriverManager.getConnection(getUrl(),getUsername(),getPassword()));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConn() {
        return conn;
    }
}
