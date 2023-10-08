/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-16 19:50:14
 * @LastEditTime: 2021-10-16 19:50:14
 * @LastEditors: hz157
 */
import java.util.Scanner;


class Person{
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    
    public Person(){
        System.out.println("This is a no-argument constructor");
    }
    public Person(int id){
        this.id = id;
    	this.name = "null";
    	this.phoneNumber = "null";
    	this.address = "null";
        System.out.println("This is a single parameter constructor");
    }
    public Person(int id, String name, String phoneNumber, String address){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        System.out.println("This is a multi-parameter constructor");
    }
    public void setid(int id){
        this.id = id;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setphoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setaddress(String address){
        this.address = address;
    }
    public int getid(){
        return(this.id);
    }
    public String getname(){
        return(this.name);
    }
    public String getphoneNumber(){
        return(this.phoneNumber);
    }
    public String getaddress(){
        return(this.address);
    }
}



public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int id;
        int[] Rank = {0,1,2};
        String name,phone,address;
        id = sc.nextInt();
        name = sc.next();
        phone = sc.next();
        address = sc.next();
        Person[] p = new Person[3];
        p[0] = new Person();
        p[0].setid(id);
        p[0].setname(name);
        p[0].setphoneNumber(phone);
        p[0].setaddress(address);
        p[1] = new Person(sc.nextInt());
        p[2] = new Person(sc.nextInt(),sc.next(),sc.next(),sc.next());
        System.out.println("Person [id=" + p[1].getid() + ", name=" + p[1].getname() + ", phoneNumber=" + p[1].getphoneNumber() + ", address=" + p[1].getaddress() + "]");
        System.out.println("Person [id=" + p[0].getid() + ", name=" + p[0].getname() + ", phoneNumber=" + p[0].getphoneNumber() + ", address=" + p[0].getaddress() + "]");
	    System.out.println("Person [id=" + p[2].getid() + ", name=" + p[2].getname() + ", phoneNumber=" + p[2].getphoneNumber() + ", address=" + p[2].getaddress() + "]");
    }

}

