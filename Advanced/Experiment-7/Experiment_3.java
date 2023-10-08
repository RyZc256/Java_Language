package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Experiment_3 {
    public static void main(String[] args) {
        ArrayList<String > list=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            list.add(sc.next());
        }
        Collections.sort(list);
        for(String i:list){
            System.out.println(i);
        }

    }
}
