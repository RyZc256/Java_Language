package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Experiment_3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = Search("/Users/horizon/Desktop/test");
        ArrayList<String> p = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++)
            if (arrayList.get(i).contains("demo"))
                p.add(arrayList.get(i));
        for (String i : p)
            System.out.println(i);
        Write("/Users/horizon/Desktop/test/demo.txt",p);
    }

    public static ArrayList<String> Search (String path){
        File file = new File(path);
        if(file.isFile())
            return null;
        File[] dir = file.listFiles();
        ArrayList<String> arrayList = new ArrayList<>();
        for(File i:dir){
            arrayList.add(i.toString());
            var dg = Search(i.toString());
            if(dg!=null)
                for(String j:dg)
                    arrayList.add(j);
        }
        return arrayList;
    }
    public static void Write(String path,ArrayList<String> data){
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
            for(String i:data){
                fw.write(i+"\n");
                fw.flush();
            }
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
