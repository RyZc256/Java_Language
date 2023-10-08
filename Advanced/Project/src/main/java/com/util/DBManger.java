package com.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBManger {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection conn;


    /**
     * 构造函数
     * 数据库链接初始化
     */
    public DBManger(){
        try{

            /** Added Maven framework to cause error report (Unresolved) **/

            // 读取指定文件内容
            Properties p = new Properties();
            InputStream is = this.getClass().getResourceAsStream("db_config.ini");
            p.load(is);

//             查找文件内指定的关键字
            setDriver(p.getProperty("driver"));
            setUrl(p.getProperty("url"));
            setUsername(p.getProperty("username"));
            setPassword(p.getProperty("password"));

            /** error report code **/

//            setDriver("com.mysql.cj.jdbc.Driver");
//            setUrl("jdbc:mysql://java.myjavaproject.cn/java_advanced?characterEncoding=utf-8&useOldAliasMetadataBehavior=true");
//            setUsername("java_advanced");
//            setPassword("faXh2m3LN6CWJ2tD");

            // 加载数据库驱动
            Class.forName(getDriver());

            // 设置数据库参数
            setConn(DriverManager.getConnection(getUrl(),getUsername(),getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
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

}
