package UI;

import SQL.sqloperation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.*;

public class User {
    private String Order_ID;
    private String Order_Type;
    private String Order_CDate;
    private String Order_JDate;
    private String SFZ;
    private double Order_Price;
    private SQL.sqloperation db;

    User(){
        db = new sqloperation();
    }

    /**
     * 支付更新数据
     * @return
     */
    public boolean Purchase(){
        String sql = "update Sale set PStatus='1' where SID='" + getOrder_ID() + "';";
        return db.update(sql);
    }

    /**
     * 创建订单插入数据
     */
    public void Order(){
        String sql = "INSERT INTO Sale VALUES('" + getOrder_ID() + "','" + getSFZ() + "','" + getOrder_Type() + "'," + getOrder_Price() + ",'" + getOrder_CDate() + "','" + getOrder_JDate() + "','0','0');";
        if(db.insert(sql)){
            JOptionPane.showMessageDialog(null,"下单成功，请确认信息付款","购票系统",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"下单失败，请重新下单","购票系统",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 修改订单更新数据
     */
    public void Update(){
        String del_sql = "delete from Sale where SID='" + getOrder_ID() + "';";
        String ins_sql = "INSERT INTO Sale VALUES('" + getOrder_ID() + "','" + getSFZ() + "','" + getOrder_Type() + "'," + getOrder_Price() + ",'" + getOrder_CDate() + "','" + getOrder_JDate() + "','0','0');";
        if(db.delete(del_sql)){
            if(db.insert(ins_sql)){
                JOptionPane.showMessageDialog(null,"修改成功，请确认信息付款","购票系统",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"修改失败","购票系统",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"修改失败","购票系统",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 获取历史订单
     */
    public DefaultTableModel GetHistory(){
        String sql = "select * from Sale where ID='" + getSFZ() + "' and PStatus = 1;";
        return db.Gethistory(sql);
    }

    public String getSFZ() {
        return SFZ;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public String getOrder_Type() {
        return Order_Type;
    }

    public String getOrder_CDate() {
        return Order_CDate;
    }

    public String getOrder_JDate() {
        return Order_JDate;
    }

    public double getOrder_Price() {
        return Order_Price;
    }

    public void setSFZ(String SFZ) {
        this.SFZ = SFZ;
    }

    public void setOrder_ID(String order_ID) {
        Order_ID = order_ID;
    }

    public void setOrder_Type(String order_Type) {
        Order_Type = order_Type;
    }

    public void setOrder_CDate(String order_CDate) {
        Order_CDate = order_CDate;
    }

    public void setOrder_JDate(String order_JDate) {
        Order_JDate = order_JDate;
    }

    public void setOrder_Price(double order_Price) {
        Order_Price = order_Price;
    }
}
