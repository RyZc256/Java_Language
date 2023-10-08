/*
 * @Description: 7-8 通过键盘输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 (10 分)
 * 统计一行字符串中的英文字母个数、空格个数、数字个数、其他字符个数
 * @Author: hz157
 * @Date: 2021-09-29 19:59:46
 * @LastEditTime: 2021-09-29 19:59:46
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class Main {
   public static void main(String[] args){
       String Data;
       Scanner in = new Scanner(System.in);
       Data = in.nextLine();
       char[] chars = Data.toCharArray();
       int letter=0,number=0,space=0,other=0;
       for (int i=0;i<chars.length;i++){
           if(chars[i]>='A' && chars[i]<='Z' || chars[i]>='a' && chars[i]<='z')
               letter++;
           else if(chars[i]>=47 && chars[i]<=57)
               number++;
           else if(chars[i]==32)
               space++;
           else
               other++;
       }
       System.out.println("字母个数：" + letter);
       System.out.println("数字个数：" + number);
       System.out.println("空格个数：" + space);
       System.out.println("其他字符个数：" + other);
   }
}