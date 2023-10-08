package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Reverse rvs = new Reverse();
        rvs.Reverse();
       Count cou = new Count();
       cou.Count();
       Number nb = new Number();
       nb.Count();
       ExceptionTest1 ect1 = new ExceptionTest1();
       ect1.ExceptionTest1();
       ExceptionTest2 ect2 = new ExceptionTest2();
       ect2.main();
    }
}


class Reverse{
    void Reverse(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        for(int i=0;i<split.length;i++){
            StringBuffer temp = new StringBuffer(split[i]);
            System.out.print(String.format("%s ",temp.reverse().toString()));
        }
    }
}

class Count{
    void Count(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuffer str = new StringBuffer("");
        char temp = 0;
        int sum = 1;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == temp){
                sum++;
            }else{
                if(sum!=1)
                    str.append(sum);
                temp = input.charAt(i);
                str.append(temp);
                sum = 1;
            }
        }
        str.append(sum);
        System.out.println(str);
    }
}


class Number{
    void Count(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int sum = 1;
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        ArrayList appear = new ArrayList();
        for(int i=0;i<input.length();i++){
            for(int j=0;j<num.length;j++){
                if(input.charAt(i) == num[j]){
                    sum++;
                    appear.add(input.charAt(i));
                }
            }
        }
        appear = remove(appear);
        System.out.println("数字字符：" + appear);
        System.out.println(String.format("数字个数：%d",sum));
    }

    public ArrayList remove(ArrayList list){
        for(int i=0;i<list.size()-1;i++){
            for(int j=list.size()-1;j>i;j--){
                if(list.get(i).equals(list.get(j)))
                    list.remove(j);
            }
        }
        return list;
    }
}


class ExceptionTest1{
    void ExceptionTest1(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                int num = Integer.parseInt(sc.nextLine());
                break;
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                System.out.println("TryCatch");
            }
        }
    }
}

class ExceptionTest2{
    void go(String k) throws Exception {
        if(k.length()<6){
            throw new Exception("长度小于6");
        }
    }
    void main(){
        String str1 = "1234567";
        String str2 = "12345";
        try{
            go(str1);
            go(str2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}