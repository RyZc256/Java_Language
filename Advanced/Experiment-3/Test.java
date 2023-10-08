package com;

public class Test {
    public static void main(String[] args){
        Hospital doctor = new Doctor("厦门医院","张三",true);
        doctor.printInfo();
        Hospital patient = new Patient("厦门医院","王五",false);
        patient.printInfo();
    }
}