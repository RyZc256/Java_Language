package com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入手机号：");
        String phone = sc.next();
        Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{4,8}$");
        Matcher m = p.matcher(phone);
        // 判断手机号码是否合法
        if(phone.length() != 11){
            System.out.println("手机号少于11位");
        }else{
            if(m.matches())
                System.out.println("输入的手机号格式正确");
            else
                System.out.println("输入的手机号格式不正确");
        }

        // 判断姓名是否合法
        if(name.length()>=2){
            p = Pattern.compile("^[\u4e00-\u9fa5]{0,}$");
            m = p.matcher(name);
            if(m.matches())
                System.out.println("姓名合法");
            else
                System.out.println("姓名不合法");
        }else
            System.out.println("姓名不合法");
    }

}
