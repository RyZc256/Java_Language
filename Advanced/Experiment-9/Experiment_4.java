package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Experiment_4 {

    static long max;
    static String name;

    //4. 查找c:\test目录下文件最大的文件路径，并将结果输出到ｃ:\test\result.txt中
    public static void main(String[] args) {
        max = -1;
        name = "";
        Get("/Users/horizon/Desktop/test");
        Write("/Users/horizon/Desktop/test/result.txt",String.format("Path:%s,Size:%d",name,max));
    }

    public static long GetFileSize(String path){
        File file = new File(path);
        if(!file.exists() || !file.isFile()){
            return -1;
        }
        return file.length();
    }

    public static void Get(String path){
        File file = new File(path);
        File[] dir = file.listFiles();
        if(dir!=null){
            for (File i:dir) {
                Get(i.toString());
                if(GetFileSize(i.toString()) > max){
                    max = GetFileSize(i.toString());
                    name = i.toString();
                }
            }
        }
    }

    public static void Write(String path,String data){
        File file = new File(path);
        BufferedWriter bw;
        if(!file.exists()){
            try{
                file.createNewFile();
                file = new File(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            FileWriter fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);
            fw.write(data);
            fw.flush();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
