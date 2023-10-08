/**
 * @description: 项目实体类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 */

package com.entity;

import com.util.DBManager;

import java.sql.ResultSet;

public class Project {
    private int P_ID;
    private String P_Name;
    private String P_Date;

    private String P_Tag;
    private int U_ID;


    /**
     * 构造函数
     * @param p_ID 项目ID
     * @param p_Name 项目名称
     * @param p_Date 项目创建日期
     * @param u_Id 项目所属用户ID
     */
    public Project(int p_ID,String p_Name,String p_Date,int u_Id,String p_Tag){
        P_ID = p_ID;
        P_Name = p_Name;
        P_Date = p_Date;
        U_ID = u_Id;
        P_Tag = p_Tag;
    }

    /**
     * 构造函数
     * @param p_Name 项目名称
     * @param p_Tag 设备标识
     */
    public Project(String p_Name,String p_Tag,User user){
        P_Name = p_Name;
        P_Tag = p_Tag;
        U_ID = user.getU_ID();
    }

    public Project(){

    }

    public Project(String p_ID) {
        init(Integer.parseInt(p_ID));
    }

    public void init(int p_ID){
        DBManager db = new DBManager();
        // 查询用户的所有信息

        String sql = String.format("select * from project where P_ID=%s",p_ID);
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                setP_ID(p_ID);
                setU_ID(rs.getInt("U_ID"));
                setP_Date(rs.getString("P_Date"));
                setP_Tag(rs.getString("P_Tag"));
                setP_Name(rs.getString("P_Name"));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getP_ID() {
        return P_ID;
    }

    public String getP_Name() {
        return P_Name;
    }

    public String getP_Date() {
        return P_Date;
    }

    public int getU_ID() {
        return U_ID;
    }

    public String getP_Tag() {
        return P_Tag;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public void setP_Date(String p_Date) {
        P_Date = p_Date;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public void setP_Tag(String p_Tag) {
        P_Tag = p_Tag;
    }

    @Override
    public String toString() {
        return "Project{" +
                "P_ID=" + P_ID +
                ", P_Name='" + P_Name + '\'' +
                ", P_Date='" + P_Date + '\'' +
                ", P_Tag='" + P_Tag + '\'' +
                ", U_ID=" + U_ID +
                '}';
    }
}
