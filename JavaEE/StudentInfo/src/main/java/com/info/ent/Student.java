package com.info.ent;

public class Student {
    private int sid;
    private String s_name;
    private String s_profession;

    public int getSid() {
        return sid;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_profession() {
        return s_profession;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_profession(String s_profession) {
        this.s_profession = s_profession;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", s_name='" + s_name + '\'' +
                ", s_profession='" + s_profession + '\'' +
                '}';
    }

    public Student(){

    }
}
