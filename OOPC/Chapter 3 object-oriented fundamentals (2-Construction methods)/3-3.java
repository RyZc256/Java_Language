/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:50:22
 * @LastEditTime: 2021-10-16 19:50:22
 * @LastEditors: hz157
 */
import java.lang.reflect.*;
import java.util.Scanner;

class Calculator{
    final static double PI = 3.14;
    final static double E = 2.71828;
    public static double add(double numb1,double numb2){
        return numb1 + numb2;
    }
    public static double substract(double numb1,double numb2) {
        return numb1 - numb2;
    }
    public static double multiply(double numb1,double numb2) {
        return numb1 * numb2;
    }
    public static double doubledivide(double numb1,double numb2) {
        return numb1 / numb2;
    }
    public static double perimeter(double numb) {
        return numb * PI * 2;
    }
    public static double area(double numb) {
        return PI * numb * numb;
    }
    public static double log(double numb) {
        return Math.log10(numb) / Math.log10(Calculator.E);
    }
}

class Main{
    public static void main(String args[]){
        double a,b,c,d;
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        System.out.println(Calculator.add(a,b));
        System.out.println(Calculator.substract(a,b));
        System.out.println(Calculator.multiply(a,b));
        System.out.println(Calculator.doubledivide(a,b));
        System.out.println(Calculator.perimeter(c));
        System.out.println(Calculator.area(c));
        System.out.println(Calculator.log(d));
        Class<?> clazz = Calculator.class;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        boolean flag=true;
        System.out.println(clazz);
        for (Field field : fields) {
            if(Modifier.isFinal(field.getModifiers())&&Modifier.isStatic(field.getModifiers())!=true)
                flag=false;
        }
        for (Method method : methods) {
            if(Modifier.isStatic(method.getModifiers())!=true)
                flag=false;
        }
        System.out.println(flag);
    }
}
