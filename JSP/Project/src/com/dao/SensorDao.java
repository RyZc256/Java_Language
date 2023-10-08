
/**
 * @description: 设备操作工具类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 */

package com.dao;

import com.entity.Sensor;
import com.entity.Project;
import com.util.Cloud;
import com.util.DBManager;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SensorDao {
    private Project project;
    private DBManager db;

    private Cloud cloud;

    public static void main(String[] args) {
        ProjectDao pm = new ProjectDao();
        Project p = new Project("486378");
        pm.getProject(p);
        SensorDao em = new SensorDao(p);
        ArrayList<Sensor> as = em.getAllSensor();
        for (Sensor i:as)
            System.out.println(i.toString());
    }
    public SensorDao(Project p){
        project = p;
        db = new DBManager();
        cloud = new Cloud();
    }

    /**
     * 查找项目下的所有设备
     * @return 设备ArrayList
     */
    public ArrayList<Sensor> getAllSensor(){
        ArrayList<Sensor> result = new ArrayList<>();
        String sql = String.format("SELECT * FROM sensor WHERE P_ID=%s", project.getP_ID());
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                Sensor e = new Sensor(Integer.parseInt(rs.getString("S_ID")));
                result.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 添加设备
     * @param project 项目实体
     * @param sersor 传感器
     * @return true 添加成功 false 添加失败
     */
    public boolean addSensor(Project project, Sensor sersor){
        boolean[] result = cloud.addSensor(project,sersor);
        return result[0] && result[1];
    }

    /**
     * 修改设备参数
     * @param project 项目实体
     * @param sersor 传感器
     * @return true 修改成功 false 修改失败
     */
    public boolean editSensor(Project project, Sensor sersor){
        boolean[] result = cloud.updateSensor(project,sersor);
        return result[0] && result[1];
    }

    /**
     * 删除设备
     * @param project 项目实体
     * @param sersor 设备实体
     * @return true 删除成功 false 删除失败
     */
    public boolean delSensor(Project project, Sensor sersor){
        boolean[] result = cloud.delSensor(project,sersor);
        return result[0] && result[1];
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

