package com;
import java.util.*;

public class Hospital {
    private String name;
    Hospital(String name){
        this.name = name;
    }
    void printInfo(){
        System.out.println(String.format("医院信息：%s",name));
    }
}

class Doctor extends Hospital{
    private String name;
    Doctor(String name1, String name2, boolean IsBlack) {
        super(name1);
        this.name = name2;
        Printer p = new Printer();
        if(IsBlack)
            p.BlackPrint();
        else
            p.ColorPrint();

    }
    void printInfo(){
        super.printInfo();
        System.out.println(String.format("医生信息:%s",name));
    }
}


class Patient extends Hospital {
    private String name;
    Patient(String name1, String name2, boolean IsBlack){
        super(name1);
        this.name = name2;
        Printer p = new Printer();
        if(IsBlack)
            p.BlackPrint();
        else
            p.ColorPrint();
    }
    void printInfo(){
        super.printInfo();
        System.out.println(String.format("病人信息:%s",name));
    }

}

interface PrinterType {
    public void ColorPrint();
    public void BlackPrint();
}

class Printer implements PrinterType{
    @Override
    public void ColorPrint(){
        System.out.println("彩色打印机");
    }

    @Override
    public void BlackPrint() {
        System.out.println("黑白打印机");
    }
}

