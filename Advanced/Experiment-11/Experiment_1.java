package com;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class Experiment_1 {

    private String driver;
    private String url;
    private String username;
    private String password;
    private java.sql.Connection conn;

    public static void main(String[] args) {
        Experiment_1 e1= new Experiment_1();
        e1.init();
        Statement stmt;
        PreparedStatement ps;

        // 插入李某的数据
        String sql = "INSERT INTO tb_stu(name,sex,birth)VALUES(?,?,?)";
        try{
            ps = e1.conn.prepareStatement(sql);
            ps.setString(1,"李某");
            ps.setString(2,"女");
            ps.setString(3,"1990-10-20");
            ps.executeUpdate();
            System.out.println("insert:"+true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("insert:"+false);
        }

        // 删除1996-10-10 之前的学生
        String sqld="DELETE from tb_stu WHERE birth<\"1996-10-10\"";
        try{
            stmt = e1.conn.createStatement();
            stmt.executeUpdate(sqld);
            System.out.println("delete:" + true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("delete:" + false);
        }


        //建表
        String sqlc="CREATE TABLE tb_emp(id int NULL," +
                "name varchar(100) NULL," +
                "sex char(1) NULL," +
                "birth date NULL," +
                "dept varchar(20) NULL);";
        System.out.println(sqlc);
        try{
            stmt = e1.conn.createStatement();
            stmt.execute(sqlc);
//            stmt.executeUpdate(sqlc);
            System.out.println("create:"+true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("create:"+false);
        }

        // 插入数据
        String[] name = {"张三","大强","小王","小胖","李姨"};
        String[] sex = {"男","男","男","女","女"};
        String[] birth = {"1997-11-03","1989-06-11","1993-05-30","1991-08-10","1982-06-18"};
        String[] dept = {"开发部","营销部","财务部","开发部","人事部"};
        String sqli="INSERT INTO tb_emp(name,sex,birth,dept)VALUES(?,?,?,?)";
        try{
            for(int i=0;i<name.length;i++){
                ps = e1.conn.prepareStatement(sqli);
                ps.setString(1,name[i]);
                ps.setString(2,sex[i]);
                ps.setString(3,birth[i]);
                ps.setString(4,dept[i]);
                ps.executeUpdate();
                System.out.println("emp_insert"+ i + ":" + true);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("emp_insert:" + false);
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
