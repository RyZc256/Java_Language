package com.entity;

import java.util.ArrayList;

public class Teacher extends User {
    private int enable;

    /**
     * 数据库使用 构造函数
     * @param account 用户名
     * @param password 密码
     * @param name 姓名
     * @param sex 性别
     * @param age 年龄
     * @param idCard 身份证
     * @param telphone 联系电话
     * @param image 头像
     * @param college 所属学院
     * @param lastOnline 最后上线时间
     * @param role 用户角色
     * @param enable 是否启用
     */
    public Teacher(int account,String password,String name,String sex,int age,String idCard,String telphone,String image,String college,String lastOnline,int enable,String role,String sClass){
        super(account,password,name,sex,age,idCard,telphone,image,college,lastOnline,role,sClass);
        this.enable = enable;
    }


    /**
     * 注册使用 构造函数
     * @param account 用户名
     * @param password 密码
     * @param name 姓名
     * @param sex 性别
     * @param age 年龄
     * @param idCard 身份证
     * @param telphone 联系电话
     * @param image 头像
     * @param college 所属学院
     * @param lastOnline 最后上线时间
     * @param role 用户角色
     */
    public Teacher(int account,String password,String name,String sex,int age,String idCard,String telphone,String image,String college,String lastOnline,String role,String sClass){
        super(account,password,name,sex,age,idCard,telphone,image,college,lastOnline,role,sClass);
    }

    public Teacher(){

    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }


}
