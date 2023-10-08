package com.entity;

public class Data {
    private double value;
    private String unit;
    private int S_ID;
    private String S_Tag;
    private String datetime;

    public Data(double value,String unit,int s_ID,String s_Tag,String datetime){
        this.value = value;
        this.unit = unit;
        this.S_ID = s_ID;
        this.S_Tag = s_Tag;
        this.datetime = datetime;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public int getS_ID() {
        return S_ID;
    }

    public String getS_Tag() {
        return S_Tag;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public void setS_Tag(String s_Tag) {
        S_Tag = s_Tag;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Data{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", S_ID=" + S_ID +
                ", S_Tag='" + S_Tag + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
