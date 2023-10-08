package com;

import com.entity.Sensor;
import com.entity.Project;
import com.entity.User;
import com.dao.SensorDao;
import com.dao.ProjectDao;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // 首先创建一个用户实体
        User user= new User("ZhangSan");
        System.out.println(user.toString());

        // 查找用户名下所有的项目
        ProjectDao pm = new ProjectDao(user);
        ArrayList<Project> allProject = pm.getAllProject("1");

        // 全部设备
        ArrayList<ArrayList<Sensor>> allEquipment = new ArrayList<>();


        for (Project i:allProject) {
            System.out.println(i.toString());
            SensorDao em = new SensorDao(i);
            // 查找单个下的设备
            ArrayList<Sensor> ae = em.getAllSensor();
            for(Sensor j:ae){
                System.out.println(j.toString());
            }
            allEquipment.add(ae);
        }
        System.out.println("\n\n\n\n\n");
        for(ArrayList<Sensor> i:allEquipment){
            for(Sensor j:i){
                System.out.print("项目:" + j.getP_ID() + ":\t\t");
                System.out.println(j.toString());
            }
        }



    }
}
