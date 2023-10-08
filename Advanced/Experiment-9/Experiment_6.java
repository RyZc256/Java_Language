package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Experiment_6 {
    public static void main(String[] args) {
        String path = "/Users/horizon/Desktop/test";
        del(path);
    }
    public static void del(String path){
        System.out.println(path);
        File file = new File(path);
        File[] dir = file.listFiles();
        file.delete();
        if(dir!=null) {
            for (File i : dir) {
                del(path + i.toString());
            }
        }
    }
}
