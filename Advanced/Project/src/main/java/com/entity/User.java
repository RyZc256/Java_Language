package com.entity;

import java.util.ArrayList;

public class User {
    private int account;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String idCard;
    private String telphone;
    private String image;
    private String college;
    private String lastOnline;
    private int enable;
    private String role;
    private String sClass;

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
     * @param lastOnline 最后上线时间
     * @param role 用户角色
     */
    public User(int account,String password,String name,String sex,int age,String idCard,String telphone,String image,String college,String lastOnline,String role,String sClass){
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.idCard = idCard;
        this.telphone = telphone;
        this.image = image;
        this.college = college;
        this.lastOnline = lastOnline;
        this.role = role;
        this.sClass = sClass;
    }

    /**
     * 构造函数
     * @param account 用户名
     * @param password 密码
     */
    public User(int account,String password){
        this.account = account;
        this.password = password;
    }

    public User(){

    }


    public int getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getImage() {
        return image;
    }

    public String getCollege() {
        return college;
    }

    public String getRole() {
        return role;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public int getEnable() {
        return enable;
    }
    public String getsClass() {
        return sClass;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User{" +
                "account=" + account +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                ", telphone='" + telphone + '\'' +
                ", image='" + image + '\'' +
                ", college=" + college +
                ", lastOnline='" + lastOnline + '\'' +
                '}';
    }
}
