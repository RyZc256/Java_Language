package com;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * 数据库操作类
 */
public class DBManager {
    private String driver;
    private String url;
    private String username;
    private String password;
    private java.sql.Connection conn;
    private ResultSet rs;
    private PreparedStatement pstms;

    /**
     * 构造函数
     */
    public DBManager(){
        // 加载配置
        init();
    }

    /**
     * 初始化数据库配置
     * @return 加载状态
     */
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

    /**
     * 数据库增加,删除,更新操作
     * @param sql sql语句
     * @return
     */
    public boolean update(String sql){
        boolean result = false;
        try{
            if(pstms.executeUpdate(sql)!=0)
                result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 数据库查询操作
     * @param sql sql语句
     * @return
     */
    public ResultSet query(String sql){
        try{
            pstms = conn.prepareStatement(sql);
            return pstms.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭链接
     * @return
     */
    public boolean close(){
        try{
            if(conn!=null)
                conn.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public java.sql.Connection getConn() {
        return conn;
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

    public PreparedStatement getPstms() {
        return pstms;
    }

    public void setPstms(PreparedStatement pstms) {
        this.pstms = pstms;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void setDriver(String drive) {
        this.driver = drive;
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

    public void setConn(java.sql.Connection conn) {
        this.conn = conn;
    }

}
