package com;

public class Experiment_5 {
    enum sex{
        male,female;
    }

    public static void main(String[] args) {
        Test<Integer,Integer,Integer> date = new Test<>(2022,04,12);
        System.out.println(date.toString());
        Test<String,Double,sex> user = new Test<String,Double,sex>("张三",180.6,sex.male);
        System.out.println(user.toString());
    }

}
class Test<A, B, C> {
    A a;
    B b;
    C c;

    public Test(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Test[A:" + a + "\tB:" + b + "\tC:" + c + "]";
    }
}