/*
 * @Description: 7-2
 * @Author: hz157
 * @Date: 2021-10-12 20:45:33
 * @LastEditTime: 2021-10-12 20:45:33
 * @LastEditors: hz157
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int a,b,c,d,e;
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                d = in.nextInt();
                e = in.nextInt();
                RR rr = new RR();
                double dd = rr.fun(a,b,c,d,e);
                System.out.printf("%.2f",dd);
    }
}
class RR{
    public static double fun(int a, int b, int c, int d,int e){
        return (a+b+c+d+e)/5;
    }


}