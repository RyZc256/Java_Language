package SQL;

import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

public class sqloperation
{
    private String sqlurl = "jdbc:mysql://url:3306/ticket";
    private String username = "Ticket";
    private String password = "password";
    Connection conn;

    public static void main(String[] args){
        sqloperation obj = new sqloperation();
        obj.connect();
    }

    /**
     * 开启数据库连接
     * @return
     */
    public boolean connect(){
        boolean Result = false;
        try{
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接数据库
            conn = DriverManager.getConnection(sqlurl,username,password);
            if(!conn.isClosed()){
                Result = true;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Result;
    }

    /**
     * 关闭数据库连接
     * @return
     */
    public boolean close(){
        boolean Result = false;
        try{
            conn.close();
            Result = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return Result;
    }

    /**
     * 数据库数据更新
     * @param sql
     * @return
     */
    public boolean update(String sql){
        boolean Result = false;
        this.connect();
        try{
            Statement stmt = null;
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count > 0){
                Result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        this.close();
        return Result;
    }

    /**
     * 数据库数据删除
     * @param sql
     * @return
     */
    public boolean delete(String sql){
        boolean Result = false;
        this.connect();
        try{
            Statement stmt = null;
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count > 0){
                Result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        this.close();
        return Result;
    }

    /**
     * 数据库数据插入
     * @param sql 数据库语句
     * @return
     */
    public boolean insert(String sql){
        boolean Result = false;
        this.connect();
        try{
            Statement stmt = null;
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count > 0){
                Result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        this.close();
        return Result;
    }

    /**
     * 用户历史订单信息查询
     * @param sql
     * @return
     */
    public DefaultTableModel Gethistory(String sql){
        ResultSet rs = null;
        String[] col = { "订单编号", "身份证", "门票类型", "门票价格", "购买日期", "使用日期", "门票状态" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String SFZ = rs.getString(2);
                String Type = rs.getString(3);
                String Price = rs.getString(4);
                String CDate = rs.getString(5);
                String JDate = rs.getString(6);
                String JStatus = "";
                if(rs.getString(8).equals("1")){
                    JStatus = "已使用";
                }else{
                    JStatus = "未使用";
                }
                String[] strRow = {ID, SFZ, Type, Price, CDate, JDate, JStatus};
                // 添加行数据
                defaultTableModel.addRow(strRow);
            }
            rs.close();
            this.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return defaultTableModel;
    }

    /**
     * 获取门票类型信息
     * @param sql
     * @return
     */
    public ArrayList GetType(String sql, int flag) {
        ResultSet rs = null;
        ArrayList arr = new ArrayList();
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(flag == 1){
                while(rs.next()){
                    arr.add(rs.getString(1));
                }
            }else{
                while(rs.next()){
                    arr.add(rs.getString(2));
                }
            }
            this.close();
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 检票查询
     * @param sql
     * @return
     */
    public String[] Check(String sql){
        String[] Result = new String[3];
        // 赋初值为空
        ResultSet rs = null;
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                if(rs.getString(7).equals("1")){
                    // 门票类型
                    Result[0] = rs.getString(3);
                    // 门票日期
                    Result[1] = rs.getString(6);
                    // 门票状态
                    Result[2] = rs.getString(8);
                }
            }
            rs.close();
            this.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Result;
    }

    /**
     * 获取所有门票类型
     * @param sql
     * @return
     */
    public DefaultTableModel GetType(String sql){
        ResultSet rs = null;
        String[] col = { "门票类型", "门票价格" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String Type = rs.getString(1);
                String Price = rs.getString(2);
                String[] strRow = {Type, Price};
                // 添加行数据
                defaultTableModel.addRow(strRow);
            }
            rs.close();
            this.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return defaultTableModel;
    }

    /**
     * 获取数据
     * @param sql
     * @return
     */
    public DefaultTableModel GetRecord(String sql){
        ResultSet rs = null;
        String[] col = { "订单编号", "身份证", "门票类型", "门票价格", "创建日期", "使用日期", "付款状态", "门票状态" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String ID = rs.getString(1);
                String SFZ = rs.getString(2);
                String Type = rs.getString(3);
                String Price = rs.getString(4);
                String CDate = rs.getString(5);
                String JDate = rs.getString(6);
                String PStatus = rs.getString(7);
                String EStatus = rs.getString(8);
                if(EStatus.equals("1")){
                    EStatus = "已使用";
                }else{
                    EStatus = "未使用";
                }
                if(PStatus.equals("1")){
                    PStatus = "已付款";
                }else{
                    PStatus = "未付款";
                }
                String[] strRow = {ID, SFZ, Type, Price, CDate, JDate, PStatus ,EStatus};
                // 添加行数据
                defaultTableModel.addRow(strRow);
            }
            rs.close();
            this.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return defaultTableModel;
    }

    /**
     * 获取订单数据
     * @param sql
     * @return
     */
    public double[] GetData(String sql){
        ResultSet rs = null;
        double[] Result = {0.0, 0.0};
        this.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Result[0]++;
                Result[1] += Double.parseDouble(rs.getString(4));
            }
            rs.close();
            this.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Result;
    }
}
