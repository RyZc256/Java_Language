package com.poji;

import java.util.List;

/**
 * 班级持久化类
 */
public class Clas {
    private Integer id;                       // 主键id
    private String classname;                // 班级名称
    private List<Student> studentList;    // 学生集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", classname='" + classname +
                ", studentList=" + studentList + '}';
    }
}


