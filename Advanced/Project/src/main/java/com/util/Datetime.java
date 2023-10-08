/**
 * @description: 时间工具类
 * @LastEdit: 2022.05.05 15:38:00
 * @Author: RyanZhang
 */

package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datetime extends Thread {
    SimpleDateFormat sdf;
    java.util.Date clock;
    Calendar time;


    /**
     * 构造函数
     */
    public Datetime(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        clock = new java.util.Date();
        time = Calendar.getInstance();
    }

    /**
     * 获取当前时间
     * @return 当前的时间 yyyy-MM-dd HH:mm:ss 格式
     */
    public String now(){
        return sdf.format(clock);
    }

    /**
     * 获取移动时间——分
     * @param minute 移动的分钟数
     * @return 移动后的时间 yyy-MM-dd HH:mm:ss 格式
     */
    public String moveMinute(int minute){
        time.add(Calendar.MINUTE,minute);
        clock = time.getTime();
        return sdf.format(clock);
    }

    /**
     * 获取移动时间——时
     * @param hour 移动的小时数
     * @return 移动后的时间 yyy-MM-dd HH:mm:ss 格式
     */
    public String moveHour(int hour){
        time.add(Calendar.HOUR,hour);
        clock = time.getTime();
        return sdf.format(clock);
    }

    /**
     * 获取移动时间——天
     * @param date 移动的天数
     * @return 移动后的时间 yyy-MM-dd HH:mm:ss 格式
     */
    public String moveDate(int date){
        time.add(Calendar.DATE,date);
        clock = time.getTime();
        return sdf.format(clock);
    }

    /**
     * 获取移动时间——年
     * @param year 移动的年
     * @return 移动后的时间 yyyy-MM-dd HH:mm:ss 格式
     */
    public String moveYear(int year){
        time.add(Calendar.YEAR,year);
        clock = time.getTime();
        return sdf.format(clock);
    }

    /**
     * 获取今日日期
     * @return 今日日期 yyyy-MM-dd 格式
     */
    public String toDay(){
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        return day.format(clock);
    }

    public int compare(String datetime1,String datetime2){
        try{
            Date date1 = sdf.parse(datetime1);
            Date date2 = sdf.parse(datetime2);
            if (date1.compareTo(date2) > 0) {
                // Date1 时间在 Date2 之后
                return 1;
            } else if (date1.compareTo(date2) < 0) {
                // Date1 时间在 Date2 之前
                return 2;
            } else if (date1.compareTo(date2) == 0) {
                // Date1 时间与 Date2 相等
                return 3;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;

    }



}