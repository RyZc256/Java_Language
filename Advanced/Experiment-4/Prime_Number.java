import java.util.Scanner;

public class Prime_Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int flag = 0;
        if(number == 1){
            flag = 1;
        }else{
            for(int i=2;i<number;i++){
                if(number % i == 0){
                    flag = 1;
                }
            }
        }
        if(flag == 1)
            System.out.println("不是质数");
        else
            System.out.println("是质数");
    }
}