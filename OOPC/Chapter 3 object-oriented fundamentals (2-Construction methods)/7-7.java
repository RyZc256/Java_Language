/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:50:30
 * @LastEditTime: 2021-10-16 19:50:30
 * @LastEditors: hz157
 */
class Book{
    private String bookname;
    private static int bookid;
    private double bookprice;
    static int count;
    public Book(){}
    public Book(String title,double price){
        this.bookname = title;
        this.bookprice = price;
        count++;
    }
    public void display(){
        bookid++;
        System.out.println("书名："+bookname+", 书号："+bookid+", 书价："+bookprice);
    }
}

class Main{
    public static void main(String args[]){
        Book b1 = new Book("Java程序设计",34.5);
        Book b2 = new Book("数据结构",44.8);
        Book b3 = new Book("C++程序设计",35.0);
        b1.display();
        b2.display();
        b3.display();
        System.out.println("图书总册数为："+Book.count);
    }
}
