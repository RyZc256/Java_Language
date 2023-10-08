import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        System.out.println("1.客户信息管理");
        System.out.println("2.购物结算");
        System.out.println("3.真情回馈");
        System.out.println("4.注销\n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while (input < 0 | input > 4){
            System.out.println("输入有误，请重新输入数字：");
            input = sc.nextInt();
        }
        switch (input){
            case 1:
                System.out.println("执行显示客户信息管理菜单");
                break;
            case 2:
                System.out.println("执行显示购物结算菜单");
                break;
            case 3:
                System.out.println("执行显示真情回馈菜单");
                break;
            case 4:
                System.out.println("执行显示注销菜单");
                break;
        }
        System.out.println("程序结束");
        System.exit(0);
    }
}