/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:50:04
 * @LastEditTime: 2021-10-16 19:50:04
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