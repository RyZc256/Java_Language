/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:49:55
 * @LastEditTime: 2021-10-16 19:49:55
 * @LastEditors: hz157
 */
public class Main {
    public static void main(String[] args) {
        RR rr = new RR(true);
    }
}
class RR{
    public RR(){
       System.out.print("8");
    }
    public RR(int x){
       this();
       System.out.print(".");
    }
    public RR(boolean b){
       this(1);
       System.out.print("00");
    }
}