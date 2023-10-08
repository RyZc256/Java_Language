package com;

public class Experiment_1 {
    public static void main(String[] args) {
        rainbow[] rb = rainbow.values();
        for (int i=0;i<7;i++){
            System.out.println(rb[i]);
        }
    }
    enum rainbow{
        red, orange, yellow, green, blue, indigo, purple
    }
}
