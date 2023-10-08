/**
 * @description: 邮件工具类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 */

package com.util;

import com.sun.mail.util.MailSSLSocketFactory;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


public class Email {


    private String from;
    private String password;
    private String host;
    private String port;
    private String subject;
    private String content;
    Properties props;
    Session session;
    MimeMessage message;


    /**
     * 构造函数
     */
    public Email(){
        init();
        try{
            props = new Properties();
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.setProperty("mail.host", getHost());
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port", getPort());
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(getFrom(),getPassword());
                }
            });
            session.setDebug(true);
            // 创建会话
            message = new MimeMessage(session);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 初始化邮件配置
     * @return true 初始化成功 false 初始化失败
     */
    public boolean init(){
        try{
            // 读取指定文件内容
            Properties p = new Properties();
            InputStream is = this.getClass().getResourceAsStream("./email_config.ini");
            p.load(is);
            // 设置发件人
            setFrom(p.getProperty("from"));
            // 设置密码
            setPassword(p.getProperty("password"));
            // 设置邮件主机地址
            setHost(p.getProperty("host"));
            // 设置SMTP端口
            setPort(p.getProperty("port"));

/*            System.out.println(p.getProperty("from"));
            System.out.println(p.getProperty("password"));
            System.out.println(p.getProperty("host"));
            System.out.println(p.getProperty("port"));*/

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 发送邮件
     * @param address 收件人地址
     * @return true 发送成功 false 发送失败
     */
    public boolean sendMail(String address){
        boolean result = false;
        // 如果没有设置邮件主题和内容不执行发送邮件
        if(getContent()==null || getSubject()==null)
            return false;
        try{
            // 设置发件人
            message.setFrom(new InternetAddress(getFrom()));
            // 设置
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(address));
            // 邮件主题
            message.setSubject(getSubject());
            // 邮件内容
            message.setContent(getContent(),"text/html;charset=UTF-8");
            // 发送日期
            message.setSentDate(new Date());
            // 保存设置
            message.saveChanges();
            Transport transport = session.getTransport();
//            System.out.println(getHost());
//            System.out.println(getPort());
//            System.out.println(getFrom());
//            System.out.println(getPassword());
            // 连接邮件服务器
            transport.connect(getHost(),getFrom(),getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
//            System.out.println(1);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * SMTP端口号
     * @param port 端口号
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 邮件主题
     * @param subject 主题内容
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 邮件正文
     * @param content 正文内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 邮件系统用户名
     * @param username 用户名
     */
    public void setFrom(String username) {
        this.from = username;
    }

    /**
     * 邮件系统密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 邮件Host地址
     * @param url 地址
     */
    public void setHost(String url) {
        this.host = url;
    }

    public String getPort() {
        return port;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }
}
