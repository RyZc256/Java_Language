import java.util.Scanner;

public class Shopping {
    public static void main(String[] args){

        System.out.println("我行我素购物管理系统 > 购物结算\n");
        System.out.println("****************************************");
        System.out.println("请选择购买的商品编号：");
        System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
        System.out.println("****************************************");
        double total = 0;
        total += input();
        System.out.print("是否继续（y/n）");
        Scanner sc = new Scanner(System.in);
        while(sc.next().equals("y")){
            total += input();
            System.out.print("是否继续（y/n）");
        }
        System.out.println("折扣：0.8");
        System.out.println(String.format("金额总计\t ¥%s",total*0.8));
        System.out.print("实际缴费\t ¥");
        double pay = sc.nextDouble();
        while(pay < total){
            System.out.println("支付金额不足，重新支付\t ¥");
            pay = sc.nextDouble();
        }
        System.out.println(String.format("找钱\t ¥%s",pay-total*0.8));

    }
    public static double input(){
        String[] name = new String[]{"T恤","网球鞋","网球拍"};
        double[] price = new double[]{245,570,320};
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入商品编号：");
        int num = sc.nextInt();
        System.out.print("请输入购买数量：");
        int qun = sc.nextInt();
        double sum = 0;
        switch (num){
            case 1:
                System.out.println(String.format("%s\t ¥%s\t ¥%s",name[0],price[0],price[0]*qun));
                sum = price[0]*qun;
                break;
            case 2:
                System.out.println(String.format("%s\t ¥%s\t ¥%s",name[1],price[1],price[1]*qun));
                sum = price[1]*qun;
                break;
            case 3:
                System.out.println(String.format("%s\t ¥%s\t ¥%s",name[2],price[2],price[2]*qun));
                sum = price[2]*qun;
                break;
        }
        return sum;
    }
}