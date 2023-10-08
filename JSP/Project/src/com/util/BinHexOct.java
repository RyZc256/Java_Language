package com.util;

import java.util.Scanner;

public class BinHexOct {

    //16进制转10进制
    public String hexdec(String str){
        return String.valueOf(Integer.parseInt(str,16));
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println(new BinHexOct().hexdec(s.next()));
    }
}
