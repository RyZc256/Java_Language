package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Experiment_2 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String olympic = "2022-02-04";
        try {
            Date before = sdf.parse(olympic);
            long i = (System.currentTimeMillis() - before.getTime()) / (3600*24*1000);
            System.out.println("距离2022北京冬奥会已经过去：" + i + "天");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
