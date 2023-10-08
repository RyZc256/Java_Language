/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-21 20:44:45
 * @LastEditTime: 2021-10-21 20:44:45
 * @LastEditors: hz157
 */
import java.util.Scanner;

class Shape{
    public Shape(){
        System.out.println("Constructing Shape");
    }
    public double getArea() {
        return 0.0;
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(){
        System.out.println("Constructing Circle");
    }
    public double getArea(){
        return Math.PI*Math.sqrt(getradius());
    }
    public void setradius(double value) {
        this.radius = value;
    }
    public double getradius(){
        return this.radius;
    }
}

class Rectangle extends Shape{
    private double width;
    private double length;
    public Rectangle(){
        System.out.println("Constructing Rectangle");
    }
    public double getArea(){
        return getlength() * getwidth();
    }
    public void setwidth(double value) {
        this.width = value;
    }
    public double getwidth(){
        return this.width;
    }
    public void setlength(double value) {
        this.length = value;
    }
    public double getlength(){
        return this.length;
    }
}

class Ball extends Circle{
    public Ball(){
        System.out.println("Constructing Ball");
    }
    public double getArea(){
        return 4.0 * Math.PI * Math.pow(getradius(),2);
    }
    public double getVolume(){
        return (4.0/3) * Math.PI * Math.pow(getradius(),3);
    }
}

class Box extends Rectangle{
    private double height;
    public Box(){
        System.out.println("Constructing Box");
    }
    public double getVolume(){
        return getheight() * getlength() * getwidth();
    }
    public double getArea(){
        return ((getlength() * getwidth()) + (getlength() * getheight()) + (getwidth() * getheight())) * 2;
    }
    public void setheight(double value) {
        this.height = value;
    }
    public double getheight(){
        return this.height;
    }
}

class Main{
    public static void main(String[] arg){
        int num;
        double[] value = new double[3];
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        switch (num) {
            case 1:
                value[0] = sc.nextDouble();
                if(value[0]>0.0){
                    Circle circle = new Circle();
                    circle.setradius(value[0]);
                    System.out.println(String.format("Circle's area:%.2f", circle.getArea()));
                }else{
                    System.out.println("Wrong Format");
                }break;
            case 2:
                value[0] = sc.nextDouble();
                value[1] = sc.nextDouble();
                if(value[0]>0.0 && value[1]>0.0){
                    Rectangle rct = new Rectangle();
                    rct.setwidth(value[0]);
                    rct.setlength(value[1]);
                    System.out.println(String.format("Rectangle's area:%.2f", rct.getArea()));
                }else{
                    System.out.println("Wrong Format");
                }break;
            case 3:
                value[0] = sc.nextDouble();
                if(value[0]>0.0){
                    Ball ba = new Ball();
                    ba.setradius(value[0]);
                    System.out.println(String.format("Ball's surface area:%.2f", ba.getArea()));
                    System.out.println(String.format("Ball's volume:%.2f", ba.getVolume()));
                }else{
                    System.out.println("Wrong Format");
                }break;
            case 4:
                value[0] = sc.nextDouble();
                value[1] = sc.nextDouble();
                value[2] = sc.nextDouble();
                if(value[0]>0.0 && value[1]>0.0 && value[2]>0.0){
                    Box bx = new Box();
                    bx.setwidth(value[0]);
                    bx.setlength(value[1]);
                    bx.setheight(value[2]);
                    System.out.println(String.format("Box's surface area:%.2f", bx.getArea()));
                    System.out.println(String.format("Box's volume:%.2f", bx.getVolume()));
                }else{
                    System.out.println("Wrong Format");
                }break;
            default:
                System.out.println("Wrong Format");
                break;
        }
    }
}