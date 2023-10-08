/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:49:44
 * @LastEditTime: 2021-10-16 19:49:44
 * @LastEditors: hz157
 */
public class Main {
    public Main(){
        System.out.println("构造方法一被调用了");
    }
    public Main(int x){
        this();
        System.out.println("构造方法二被调用了");
    }
    public Main(boolean b){
        this(1);
        System.out.println("构造方法三被调用了");
    }
    public static void main(String[] args) {
       Main m = new Main(true);
    }
}