/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-04 15:33:07
 * @LastEditTime: 2021-10-04 15:33:22
 * @LastEditors: hz157
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            if(Math.abs(a)>1000){
                System.out.println("|a|>1000");
            }else{
                System.out.println(a+b);
            }
        }
    }
}
