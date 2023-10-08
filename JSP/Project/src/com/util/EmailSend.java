/**
 * @description: 项目操作工具类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 * @Remarks: 后面可能会增加数据告警邮件通知
 */

package com.util;

import com.entity.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class EmailSend {

    private String to;
    Email mail;
    Date clock;
    SimpleDateFormat sdf;

    /**
     * 构造函数
     * @param address 邮件地址
     */
    public EmailSend(String address){
        mail = new Email();
        setTo(address);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 注册邮件通知
     * @param user 用户名
     * @return true发送成功 false发送失败
     */
    public boolean register(String user){
        mail.setSubject("注册成功邮件通知——物联网数据可视化系统");
        mail.setContent(String.format("恭喜你%s，成功注册物联网数据可视化系统，即刻开始你的物联网之旅吧。",user));
        if(mail.sendMail(getTo()))
            return true;
        else
            return false;

    }

    /**
     * 找回密码
     * @param user 用户名
     * @return String 验证码
     */
    public String retrieve(User user){
        String code = random();
        mail.setSubject("找回密码——物联网数据可视化系统");
        mail.setContent(String.format("%s\n你的验证码是：%s,30分钟内有效。",user.getU_Account(),code));
        mail.sendMail(getTo());
        return code;
    }

    /**
     * 验证码生成 6位数
     * @return String 验证码
     */
    public String random(){
        return String.valueOf(new Random().nextInt(10000,999999));
    }

    /**
     * 写入验证码 !==== 弃用方法
     * @param user 用户名
     * @param code 验证码
     * @param ftime 失效时间
     * @return true 写入成功 false 写入失败
     */
    public boolean writeCode(String user,String code,String ftime){
        String sql = String.format("insert into T_CheckCode (C_Account,C_Code,C_FTime,C_Function) values(\"%s\",\"%s\",\"%s\",\"retrieve\"",user,code,ftime);
        DBManager db = new DBManager();
        return db.update(sql);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


}
