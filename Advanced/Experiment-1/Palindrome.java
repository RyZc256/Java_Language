import java.util.*;

public class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        int[] num = new int[5];
        boolean flag = true;
        for(int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(data.substring(i,i+1));
        }
        for(int i=0;i<num.length/2;i++){
            if(num[i] != num[num.length-1-i])
                flag = false;
        }
        if(!flag)
            System.out.println("不是回文数");
        else
            System.out.println("是回文数");
    }
}