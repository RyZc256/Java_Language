import java.lang.reflect.Array;
import java.util.*;

public class Sort {
    public static void main(String[] args){
        int[][] arr = {
                {8,2,5,1},
                {3,5,7,8},
                {6,8,2,1}
        };
        for (int i=0;i<3;i++){
            Arrays.sort(arr[i]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1==o2)
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for (int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.print(String.format("%s\t",arr[i][j]));
            }
            System.out.println();
        }
    }
}