/*
 * @Description: 7-32 组合找出最大值和最小值 (10 分)
 * @Author: hz157
 * @Date: 2021-09-29 20:00:46
 * @LastEditTime: 2021-09-29 20:00:46
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class k09_26 {
   public static void main(String[] args){
       int[] num = new int[4];
       int min = 0,max = 0;
       int tmp = 0;
       Scanner in = new Scanner(System.in);
       try {
           for(int i=0;i<4;i++){
               num[i] = in.nextInt();
               // 范围溢出
               if(0>num[i] || num[i]>9){
                   System.out.println("Numerical range error");
                   return;
               }
           }
           // 冒泡排序
           for (int i=0;i<4;i++){
               for (int j=1;j<4-i;j++){
                   if(num[j-1]>num[j]){
                       tmp = num[j-1];
                       num[j-1] = num[j];
                       num[j] = tmp;
                   }
               }
           }
           min = num[0]*1000+num[1]*100+num[2]*10+num[3];
           max = num[3]*1000+num[2]*100+num[1]*10+num[0];
           System.out.println(max + " " + min);
       }catch(Exception e){
           System.out.println("number input error");
       }
   }
}
