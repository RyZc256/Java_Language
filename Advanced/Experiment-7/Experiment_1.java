package com;

import java.util.ArrayList;
import java.util.Iterator;

public class Experiment_1 {
}

class Cat{
    private String name;
    Cat(String data){
        setName(data);
    }

    public void show(){
        System.out.println(getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CatTest{
    public static void main(String[] args) {
        Cat c1 = new Cat("波斯猫");
        Cat c2 = new Cat("英国短毛猫");
        Cat c3 = new Cat("橘猫");
        ArrayList<Cat> array = new ArrayList<Cat>();
        array.add(c1);array.add(c2);array.add(c3);
        for (Cat i:array)
            i.show();
    }
}
