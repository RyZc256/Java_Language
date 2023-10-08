package com.entity;

public class Student extends User {

    /**
     * 构造函数
     * @param account 用户名
     * @param password 密码
     * @param name 姓名
     * @param sex 性别
     * @param age 年龄
     * @param idCard 身份证
     * @param telphone 联系电话
     * @param image 头像
     * @param college 所属学院
     * @param sClass 所属班级
     * @param lastOnline 最后上线时间
     * @param role 用户角色
     */
    public Student(int account,String password,String name,String sex,int age,String idCard,String telphone,String image,String college,String sClass,String lastOnline,String role){
        super(account,password,name,sex,age,idCard,telphone,image,college,lastOnline,role,sClass);
    }

    public Student(){

    }

}
