package com;

import java.util.HashMap;
import java.util.Scanner;

public class Experiment_6 {
}

class BookTest{
    public static void main(String[] args) {
        Book b1 = new Book("数学");
        Book b2 = new Book("英语");
        Book b3 = new Book("语文");
        int[] num = new int[]{1,2,3};
        HashMap hm = new HashMap();
        hm.put(num[0],b1);
        hm.put(num[1],b2);
        hm.put(num[2],b3);
        System.out.println("输入编号");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(hm.get(i));
    }
}


class Book{
    private String title;

    Book(String title){
        setTitle(title);
    }

    @Override
    public String toString(){
        return getTitle();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
