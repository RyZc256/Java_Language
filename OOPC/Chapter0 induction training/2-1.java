/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-04 15:34:15
 * @LastEditTime: 2021-10-04 15:34:15
 * @LastEditors: hz157
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int odd = 0, eve = 0, inp;
        int num = in.nextInt();
        for(int i=0;i<num;i++){
            inp = in.nextInt();
            if(inp % 2 == 0){
                eve += inp;
            }else{
                odd += inp;
            }
        }
        System.out.println("奇数和=" + odd + ", 偶数和=" + eve);
    }
}
