package com.util;

import com.entity.Student;
import com.entity.Teacher;

import java.util.ArrayList;

public interface InterfaceRegister {

    /**
     * 注册学生用户
     * @param student 学生实习
     * @return 注册结果
     */
    public boolean Register(Student student);

    /**
     * 注册教师用户
     * @param teacher 教师实体
     * @return 注册结果
     */
    public String Register(Teacher teacher);

    /**
     * 获取学校所有学院
     * @return 所有学院
     */
    public ArrayList<String> SelectCollege();


}
