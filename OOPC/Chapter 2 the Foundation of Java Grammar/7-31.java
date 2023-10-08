/*
 * @Description: 7-31 我是升旗手 (10 分)
 * @Author: hz157
 * @Date: 2021-09-29 19:56:35
 * @LastEditTime: 2021-09-29 19:57:43
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       int num = 0, max = 0;
       Scanner in = new Scanner(System.in);
       num = in.nextInt();
       int[] data = new int[num];
       for (int i=0;i<num;i++){
           data[i]=in.nextInt();
           if(max<data[i]){
               max = data[i];
           }
       }
       System.out.println(max);
   }
}
