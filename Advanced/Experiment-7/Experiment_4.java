package com;

import java.util.Scanner;
import java.util.TreeSet;

public class Experiment_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> ts = new TreeSet<>();
        for (int i=0;i<5;i++){
            ts.add(sc.next());
        }
        for(String i:ts){
            System.out.println(i);
        }

    }
}
