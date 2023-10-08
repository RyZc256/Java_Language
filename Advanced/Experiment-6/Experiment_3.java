package com;

import java.util.Random;
import java.util.Scanner;

public class Experiment_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        b = (int)(Math.random()*100)+1;
        do{
            a = sc.nextInt();
            if(a > b)
                System.out.println("输入的数字大了");
            else if(a < b)
                System.out.println("输入的数字小了");
        }while(a != b);
        System.out.println("用户输入与随机数相等，程序结束");
    }
}
