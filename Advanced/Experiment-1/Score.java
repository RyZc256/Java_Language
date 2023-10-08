import java.util.Scanner;

public class Score {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ac = new int[8];
        int sum = 0, max = 0, min = Integer.MAX_VALUE, avg = 0,temp = 0;

        for(int i=0;i<ac.length;i++){
            ac[i] = sc.nextInt();
            if(max < ac[i])
                max = ac[i];
            if(min > ac[i])
                min = ac[i];
            sum += ac[i];
        }
        avg = sum / 8;
        for(int i=0;i<ac.length-1;i++){
            for(int j=0;j<ac.length-1-i;j++){
                if(ac[j]>ac[j+1]){
                    temp = ac[j];
                    ac[j] = ac[j+1];
                    ac[j+1] = temp;
                }
            }
        }
        System.out.print("从小到大排序：");
        for(int i=0;i<ac.length;i++){
            System.out.print(String.format("%s\t",ac[i]));
        }
        System.out.print("\n");
        System.out.print(String.format("总分：%s\t", sum));
        System.out.print(String.format("最高分：%s\t", max));
        System.out.print(String.format("最低分：%s\t", min));
        System.out.print(String.format("平均分：%s\n", avg));

    }
}