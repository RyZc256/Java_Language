/**
 * @description: 设备实体类
 * @LastEdit: 2022.05.05 16:35:00
 * @Author: RyanZhang
 */

package com.entity;

import com.util.BinHexOct;
import com.util.DBManager;
import java.sql.ResultSet;

public class Sensor {
    // 传感器ID
    private int S_ID;
    // 传感器名称
    private String S_Name;
    // 传感器标识
    private String S_Tag;
    // 传感器序列号
    private String S_Serial;
    // 项目ID
    private int P_ID;
    // 模型ID
    private int M_ID;
    // 模型名称
    private String M_Name;
    // 数据类型
    private String M_DataType;
    // 数据单位
    private String M_Unit;



    /**
     * 构造函数
     * @param s_ID 传感器ID
     * @param s_Name 传感器名称
     * @param p_ID 传感器所属项目ID
     * @param m_ID 模型ID
     * @param m_Name 模型名称
     * @param m_DataType 数据类型
     * @param m_Unit 数据单位
     * @param s_Tag 传感器标识
     * @param s_Serial 传感器序列号
     */
    public Sensor(int s_ID, String s_Name, String s_Tag, String s_Serial, int m_ID, String m_Name, String m_DataType, String m_Unit, int p_ID){
        BinHexOct bin=new BinHexOct();
        S_ID = s_ID;
        S_Name = s_Name;
        P_ID = p_ID;
        M_ID = m_ID;
        M_Name = m_Name;
        M_DataType = m_DataType;
        M_Unit = m_Unit;
        S_Tag = s_Tag;
        S_Serial = bin.hexdec(s_Serial);
    }

    public Sensor(int s_ID){
        init(s_ID);
    }

    public Sensor(String s_Name, String s_Tag, String s_Serial, int m_ID,int p_ID){
        BinHexOct bin=new BinHexOct();
        S_Name = s_Name;
        P_ID = p_ID;
        M_ID = m_ID;
        S_Tag = s_Tag;
        S_Serial = bin.hexdec(s_Serial);
        DBManager db = new DBManager();
        String sql = String.format("SELECT * FROM sensor WHERE S_Tag=\"%s\" and P_ID=%s",getS_Tag(),getP_ID());
        ResultSet rs = db.query(sql);
        try {
            while (rs.next())
                setS_ID(rs.getInt("S_ID"));
            rs.close();
            // 查询模型
            sql = String.format("SELECT * FROM model WHERE M_ID=%s",getM_ID());
            rs = db.query(sql);
            while(rs.next()){
                setM_Name(rs.getString("M_Name"));
                setM_Unit(rs.getString("M_Unit"));
                setM_DataType(rs.getString("M_DataType"));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 初始化
     * @param s_ID 传感器ID
     * @return true 初始化成功 false 初始化失败
     */
    public boolean init(int s_ID){
        int flag = 0;
        DBManager db = new DBManager();

        // 查询传感器
        String sql = String.format("SELECT * FROM sensor WHERE S_ID=%s",s_ID);
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                setS_ID(rs.getInt("S_ID"));
                setS_Name(rs.getString("S_Name"));
                setS_Tag(rs.getString("S_Tag"));
                setS_Serial(rs.getString("S_Serial"));
                setM_ID(rs.getInt("M_ID"));
                setP_ID(rs.getInt("P_ID"));
            }
            flag++;
        }catch (Exception e){
            e.printStackTrace();
        }

        // 查询模型
        sql = String.format("SELECT * FROM model WHERE M_ID=%s",getM_ID());
        rs = db.query(sql);
        try{
            while(rs.next()){
                setM_Name(rs.getString("M_Name"));
                if(rs.getString("M_Unit").equals("null"))
                    setM_Unit("");
                else
                    setM_Unit(rs.getString("M_Unit"));
                setM_DataType(rs.getString("M_DataType"));
            }
            flag++;
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag == 2)
            return true;
        else
            return false;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public void setS_Tag(String s_Tag) {
        S_Tag = s_Tag;
    }

    public void setS_Serial(String s_Serial) {
        BinHexOct bin=new BinHexOct();
        S_Serial = bin.hexdec(s_Serial);
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public void setM_ID(int m_ID) {
        M_ID = m_ID;
    }

    public void setM_Name(String m_Name) {
        M_Name = m_Name;
    }

    public void setM_DataType(String m_DataType) {
        M_DataType = m_DataType;
    }

    public void setM_Unit(String m_Unit) {
        M_Unit = m_Unit;
    }

    public int getS_ID() {
        return S_ID;
    }

    public String getS_Name() {
        return S_Name;
    }

    public String getS_Tag() {
        return S_Tag;
    }

    public String getS_Serial() {
        return S_Serial;
    }

    public int getP_ID() {
        return P_ID;
    }

    public int getM_ID() {
        return M_ID;
    }

    public String getM_Name() {
        return M_Name;
    }

    public String getM_DataType() {
        return M_DataType;
    }

    public String getM_Unit() {
        return M_Unit;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "S_ID=" + S_ID +
                ", S_Name='" + S_Name + '\'' +
                ", S_Tag='" + S_Tag + '\'' +
                ", S_Serial='" + S_Serial + '\'' +
                ", P_ID=" + P_ID +
                ", M_ID=" + M_ID +
                ", M_Name='" + M_Name + '\'' +
                ", M_DataType='" + M_DataType + '\'' +
                ", M_Unit='" + M_Unit + '\'' +
                '}';
    }
}
