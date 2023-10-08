package com;

import java.io.File;

public class Experiment_1 {

    public static void main(String[] args) {
        // windows
//        String path = "c:\\test\\test1\\demo";
        // mac
        String path = "/Users/horizon/Desktop/test/test1/demo";
        File file = new File(path);
        if (file.mkdirs()){
            System.out.println("创建文件夹成功");
        }else
            System.out.println("创建文件夹失败");
    }

}
