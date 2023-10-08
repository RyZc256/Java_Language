package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Experiment_2 {

    public static void main(String[] args) {
        Phone p1 = new Phone("华为",9999.00,"P50");
        Phone p2 = new Phone("小米",3000.00,"Mi 12 Pro");
        Phone p3 = new Phone("华为",5000.00,"Mate 40");
        Phone p4 = new Phone("苹果",9999.00,"iPhone13 Pro");
        Phone p5 = new Phone("华为",9999.00,"P50");
        HashSet<Phone> hs = new HashSet<Phone>();
        hs.add(p1);hs.add(p2);hs.add(p3);hs.add(p4);hs.add(p5);
        int sum = 0;
        Iterator<Phone> iterator = hs.iterator();
        while(iterator.hasNext()){
            iterator.next().show();
        }
        for(Phone p:hs){
            if(p.getBrand().equals("华为"))
                sum++;
        }
        System.out.println("华为手机个数有:"+sum);
    }
}



class Phone{
    private String brand;
    private double price;
    private String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return brand.equals(phone.brand) && model.equals(phone.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    Phone(String brand, double price, String model){
        setBrand(brand);
        setPrice(price);
        setModel(model);
    }

    public void show(){
        System.out.println(String.format("品牌：%s,价格：%.2f,型号：%s",getBrand(),getPrice(),getModel()));
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
