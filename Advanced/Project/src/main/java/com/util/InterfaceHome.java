package com.util;

import com.entity.Student;
import com.entity.Task;
import com.entity.User;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public interface InterfaceHome {

    public DefaultTableModel stuGetAttend(User user);

    /**
     * 查询所有学生今日打卡记录是否存在
     * @return
     */
    public boolean stuTodayAttend();

    /**
     * 更细学生打卡状态
     * @param user 学生类
     * @return 1 打卡成功 2 打卡失败 3 已打卡
     */
    public int stuUpDateAttend(User user);

    /**
     * 获取学生未完成的任务
     * @param user 学生类
     * @return
     */
    public ArrayList<Task> stuGetTask(User user);

    /**
     * 更新学生任务完成状态
     * @param task 任务类
     * @return
     */
    public boolean stuUpDateTask(Task task);

    /**
     * 发布任务
     * @param task
     * @return
     */
    public boolean teaPublishTask(Task task,ArrayList<Student> students);

    /**
     * 结束任务
     * @param task
     * @return
     */
    public boolean teafinishTask(Task task);

    /**
     * 获取所有任务（显示）
     * @param user
     * @return
     */
    public DefaultTableModel teaGetTask(User user);

    /**
     * 获取存活任务
     * @param user
     * @return
     */
    public ArrayList<Task> teaGetSurviveTask(User user);

    /**
     * 获取所有任务 下拉框
     * @param user
     * @return
     */
    public ArrayList<Task> teaAllGetTask(User user);

    /**
     * 获取所有学生信息
     * @param user 教师实体类
     * @return
     */
    public ArrayList<Student> teaGetStu(User user);

    /**
     * 获取学生上传的文件
     * @param task 任务ID
     * @param stu 学生id
     * @return
     */
    public String getStuPath(int task,int stu);

}
