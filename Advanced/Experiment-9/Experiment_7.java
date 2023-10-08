package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Experiment_7 {
    //7. 将“你好，我的邮箱是admin@126.com或Jack@qq.com”中的邮箱提取，输出到c:\test\demo.txt
    public static void main(String[] args) {
        String text = "你好，我的邮箱是admin@126.com或Jack@qq.com";
        Pattern pattern = Pattern.compile("[\\w[.-]]+\\@[\\w[.-]]{2,}\\.[\\w[.-]]+");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> email = new ArrayList<>();
        while(matcher.find()){
            String data = matcher.group();
            email.add(data);
        }
        for(String i:email){
            System.out.println(i);
            Write("/Users/horizon/Desktop/test/demo.txt",i+"\n");
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
