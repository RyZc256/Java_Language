import java.util.*;

public class Encry {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String data = "";
        data = sc.next();
        int[] num = new int[4];
        int temp;
        System.out.println(String.format("加密前：%s",data));
        for (int i=0;i<data.length();i++){
            num[i] = Integer.parseInt(data.substring(i,i+1));
            num[i] += 5;
            num[i] %= 10;
        }
        // 14交换
        temp = num[0];
        num[0] = num[3];
        num[3] = temp;
        // 23交换
        temp = num[1];
        num[1] = num[2];
        num[2] = temp;
        data = "";
        for(int i=0;i<num.length;i++){
            data = data + num[i];
        }
        System.out.println(String.format("加密后：%s",data));
    }
}