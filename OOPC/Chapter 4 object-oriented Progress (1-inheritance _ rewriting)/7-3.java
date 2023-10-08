/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-21 20:46:03
 * @LastEditTime: 2021-10-21 20:46:03
 * @LastEditors: hz157
 */
public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.method();
    }
}

class Parent {
    Parent() {
        System.out.println("Parent's Constructor without parameter");
    }

    Parent(boolean b) {
        System.out.println("Parent's Constructor with a boolean parameter");
    }

    public void method() {
        System.out.println("Parent's method()");
    }
}

class Son extends Parent {
	public Son(){
		super(true);
		System.out.println("Son's Constructor without parameter");
	}
	public void method() {
		System.out.println("Son's method()");
		System.out.println("Parent's method()");
        
    }
}