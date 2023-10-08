package com;

import java.io.File;
import java.io.IOException;

public class Experiment_2 {
    public static void main(String[] args) {
        // Windows
//        String path = "c:\\test\\demo.txt";
        // mac
        String path = "/Users/horizon/Desktop/test/demo.txt";
        File file = new File(path);
        if(!file.exists()){
            try{
                file.createNewFile();
                System.out.println("demo.txt创建成功");
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("demo.txt创建失败");
            }
        }
        System.out.println("demo.txt已存在");
    }
}
