/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:48:45
 * @LastEditTime: 2021-10-16 19:48:46
 * @LastEditors: hz157
 */
import java.util.Scanner;

class Main{
    public static void main(String args[]){
        String name,sex;
        int age;
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        age = sc.nextInt();
        sex = sc.next();
        Student st = new Student(name,sex,age);
        st.Print();
    }
}

class Student{
    private String name;
    private String sex;
    private int age;

    public Student(String n,String s,int a){
        this.name = n;
        this.age = a;
        this.sex = s;
    }

    public void setname(String n){
        this.name = n;
    }
    public void setage(int a){
        this.age = a;
    }
    public void setsex(String s){
        this.sex = s;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
    public String getsex(){
        return sex;
    }
    public void Print(){
        System.out.println("Student [name='" + this.getname() + "', sex='" + this.getsex() + "', age=" + this.getage() + "]");
    }
}