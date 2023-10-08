package com;

import java.util.Iterator;
import java.util.TreeSet;

public class Experiment_5 {
    public static void main(String[] args) {
        TreeSet tree = new TreeSet();
        tree.add(new Student("1001","张三",18));
        tree.add(new Student("1002","王五",15));
        tree.add(new Student("1003","李四",20));
        tree.add(new Student("1004","赵六",17));
        tree.add(new Student("1005","李七",21));
        Iterator<Student> iterator = tree.iterator();
        while(iterator.hasNext()){
            iterator.next().show();
        }
    }
}

class Student implements Comparable<Student>{
    private String stuno;
    private String stuname;
    private int age;


    Student(String stuno,String stuname,int age){
        setStuno(stuno);
        setStuname(stuname);
        setAge(age);
    }

    public void show(){
        System.out.println(String.format("学号：%s，姓名：%s，年龄：%d",getStuno(),getStuname(),getAge()));
    }


    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuno() {
        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        return (this.age - o.age);
    }
}
