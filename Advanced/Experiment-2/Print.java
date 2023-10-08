package com;

public class Print  {
    private String type;
    public Print(String data){
        this.type = data;
        System.out.println(this.type);
    }
}
class BlackPrint extends print {
    public BlackPrint() {
        super("黑白打印机");
    }

}
class ColorPrint extends print {
    public ColorPrint() {
        super("彩色打印机");
    }
}