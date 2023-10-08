/**
 * @description: 项目操作工具类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 */

package com.dao;

import com.util.Cloud;
import com.entity.*;
import com.util.DBManager;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjectDao {
    private User user;
    private DBManager db;

    private Cloud cloud;

    /**
     * 构造函数
     * @param user 用户实体类
     */
    public ProjectDao(User user){
        setUser(user);
        db = new DBManager();
        cloud = new Cloud();
    }

    public ProjectDao() {
        db = new DBManager();
        cloud = new Cloud();
    }



    /**
     * 获取项目
     * @return 项目实体ArrayList
     */
    public Project getProject(Project project) {
        // 查找指定ID的项目
        String sql = String.format("SELECT * FROM project WHERE U_ID=\"%s\" and P_ID = \"%s\"", project.getU_ID(),project.getP_ID());
        System.out.println(sql);
        try{
            ResultSet rs = db.query(sql);
            while(rs.next()){
                project.setP_Name(rs.getString("P_Name"));
                project.setP_Date(rs.getString("P_Date"));
                project.setP_Tag(rs.getString("P_Tag"));
                project.setP_Date(rs.getString("P_Date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return project;
    }

    /**
     * 获取所有项目
     * @return 项目实体ArrayList
     */
    public ArrayList<Project> getAllProject(String U_ID) {
        ArrayList<Project> result = new ArrayList<>();
        ResultSet rs;
        // 查找帐号下的所有项目
        String sql = String.format("SELECT * FROM project WHERE U_ID=\"%s\"", U_ID);
        rs = db.query(sql);
        try{
            while(rs.next()){
                Project p = new Project(rs.getInt("P_ID"),
                        rs.getString("P_Name"),
                        rs.getString("P_Date"),
                        rs.getInt("U_ID"),
                        rs.getString("P_Tag"));
                result.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改项目
     * @param project 项目实体类
     * @return true 修改成功 false 修改失败
     */
    public boolean editProject(Project project){
        boolean[] result = cloud.updateProejct(project);
        return result[0] && result[1];
    }

    /**
     * 删除项目
     * @param project 项目实体类
     * @return true 成功删除 false 删除失败
     */
    public boolean deleteProject(Project project){
        boolean[] result = cloud.delProject(project);
        return result[0] && result[1];
    }

    /**
     * 添加项目
     * @param project 项目实体类
     * @return true 成功添加 false 添加失败
     */
    public boolean addProject(Project project){
        boolean[] result = cloud.addProject(project);
        return result[0] && result[1];
    }

    public boolean closeDB(){
        return db.close();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

