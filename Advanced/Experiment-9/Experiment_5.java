package com;

import java.io.*;

public class Experiment_5 {
    public static void main(String[] args) {
        String path = "/Users/horizon/Desktop/test/result.txt";
        File file = new File(path);
        String data = "";
        String p = "";
        if(!file.exists()){
            System.out.println("文件不存在");
        }else{
            try{
                BufferedReader in = new BufferedReader(new FileReader(path));
                while((data=in.readLine()) != null){
                    p += data;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println(p);
        }
    }
}
