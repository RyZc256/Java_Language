/*
 * @Description: 2-1 jmu-java-m02-循环求和 (10 分)
 * @Author: hz157
 * @Date: 2021-09-29 20:01:30
 * @LastEditTime: 2021-09-29 20:01:30
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       int num,temp;
       int x = 0, y = 0;
       Scanner in = new Scanner(System.in);
       num = in.nextInt();
       for (int i=0;i<num;i++){
           temp = in.nextInt();
           if (temp % 2 == 0)
               y+=temp;
           else
               x+=temp;
       }
       System.out.println("奇数和=" + x + ", 偶数和=" + y);
   }
}