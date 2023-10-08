package com;

import java.math.BigInteger;
import java.util.Scanner;

public class Experiment_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a,b,c;
        a = sc.nextBigInteger();
        b = sc.nextBigInteger();
        c = a.add(b);
        System.out.println(String.format("a+b=%s",c));
        c = a.subtract(b);
        System.out.println(String.format("a-b=%s",c));
        c = a.multiply(b);
        System.out.println(String.format("a*b=%s",c));
        c = a.divide(b);
        System.out.println(String.format("a/b=%s",c));
    }
}
