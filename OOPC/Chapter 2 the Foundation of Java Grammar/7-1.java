/*
 * @Description: 7-1 空心字母金字塔 (10 分)
 * @Author: hz157
 * @Date: 2021-09-29 19:58:51
 * @LastEditTime: 2021-09-29 19:58:52
 * @LastEditors: hz157
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        for (int i = 1; i <= ch - 'A' + 1; i++) {
            for (int k = 40 - i; k >= 1; k--)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (i == ch - 'A' + 1)
                    System.out.print((char) ('A' + i - 1));
                else if (j == 1 || j == 2 * i - 1)
                    System.out.print((char) ('A' + i - 1));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}