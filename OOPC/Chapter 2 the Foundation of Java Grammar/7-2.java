/*
 * @Description: 7-2 上三角数字三角形 (10 分)
 * @Author: hz157
 * @Date: 2021-09-29 20:01:57
 * @LastEditTime: 2021-09-29 20:01:57
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       int num,num1 = 1;
       Scanner in = new Scanner(System.in);
       num = in.nextInt();
       for (int i=num;i>0;i--){
           for (int j=0;j<i;j++){
               System.out.printf("%4d",num1);
               num1++;
           }
           System.out.println("");
       }
   }
}

