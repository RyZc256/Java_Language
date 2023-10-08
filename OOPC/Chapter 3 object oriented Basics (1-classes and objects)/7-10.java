/*
 * @Description: 7-10
 * @Author: hz157
 * @Date: 2021-10-12 20:46:55
 * @LastEditTime: 2021-10-12 20:46:55
 * @LastEditors: hz157
 */
public class Main {
    public static void main(String[] args) {
        Test test = new Test(true);
    }
}

class Test {
    public Test(){
        System.out.println("Constructor one invoked!");
    }
    public Test(int x){
        this();
        System.out.println("Constructor two invoked!");
    }
    public Test(boolean b){
        this(1);
        System.out.println("Constructor three invoked!");
    }

}