package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Experiment_1 {
    public static void main(String[] args) {
        Rnd r = new Rnd();
        ArrayList<Integer> list = r.GetRandom(6);
        for(int i:list)
            System.out.println(i);
    }
}

class Rnd{
    public ArrayList<Integer> GetRandom(int num){
        Random rnd = new Random();
        HashSet<Integer> element = new HashSet<Integer>();
        for(int i=0;i<num;i++)
            element.add((int)(Math.random()*25)+5);
        return new ArrayList<Integer>(element);
    }
}
