package com.util;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class FTP {

    private FTPClient ftpClient;
    private final String host = "java.myjavaproject.cn";
    private final String user = "java_epoches_cn";
    private final String pwd = "D4w2pWDYKjRNCYWX";

    public static void main(String[] args) {
        FTP f = new FTP();
        try{
            FileInputStream in=new FileInputStream(new File("/Users/horizon/Desktop/附件0《JAVA开发进阶》课程考核任务.doc"));
            System.out.println(f.uploadFile("3333.doc", in));
        }catch (Exception e){
            e.printStackTrace();
        }
        f.downloadFtpFile("222222.doc","/Users/horizon/Documents");
    }
    public FTP() {

    }

    /**
     * Description:             向FTP服务器上传文件
     * @param filename          上传到FTP服务器上的文件名
     * @param input             输入流
     * @return                  成功返回true，否则返回false
     */
    public boolean uploadFile(String filename, InputStream input) {
        boolean result = false;
        try {
            conFtpClient();
            int reply;
            ftpClient.changeWorkingDirectory("/files");
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return result;
            }
            filename = new String(filename.getBytes("GBK"));    //编码文件名，支持中文文件名
            //上传文件
            if (!ftpClient.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftpClient.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * FTP文件下载
     * @param ftpname 文件名字
     * @param path 保存路径
     * @return
     */
    public String downloadFtpFile(String ftpname,String path){
        try {
            conFtpClient();
            ftpClient.changeWorkingDirectory("/files");
            String f_ame = new String(ftpname.getBytes("GBK"));	//编码文件格式,解决中文文件名
            File localFile = new File(path + File.separator + ftpname);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(f_ame, os);
            os.close();
            ftpClient.logout();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "没有找到" + ftpname + "文件";
        } catch (SocketException e) {
            e.printStackTrace();
            return "连接FTP失败.";
        } catch (IOException e) {
            e.printStackTrace();
            return "文件读取错误。";
        }
        return "下载完成，已保存至程序运行目录";
    }


    public void conFtpClient() {
        ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(host, 21);              // 连接FTP服务器
            ftpClient.login(user, pwd);        // 登陆FTP服务器
            ftpClient.setControlEncoding("UTF-8");             // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
    }

}
