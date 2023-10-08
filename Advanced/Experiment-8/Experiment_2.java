package com;
import java.util.Scanner;

public class Experiment_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        role[] roles = role.values();
        int num = sc.nextInt();
        for(int i=0;i<4;i++){
            if(num==roles[i].role){
                System.out.println(roles[i]);
                System.out.println(roles[i].funtion);
            }
        }
    }

    enum role{
        passenger(0,"观看部分视频、浏览所有课程、注册、登录；"),
        user(1,"免费观看所有视频、部分配套习题、收藏课程、实时提问、个人设置；"),
        vip(2,"免费观看所有视频、浏览所有习题及答案、源码下载、定期在线互动交流；"),
        admin(3,"后台所有管理模块、前提所有功能模块");

        private int role;
        private String funtion;

        role(int role, String funtion) {
            this.role = role;
            this.funtion = funtion;
        }

        public int getRole() {
            return role;
        }

        public String getFuntion() {
            return funtion;
        }
    }
}
