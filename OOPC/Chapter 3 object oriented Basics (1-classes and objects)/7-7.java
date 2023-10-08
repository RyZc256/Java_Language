/*
 * @Description: 7-7
 * @Author: hz157
 * @Date: 2021-10-12 20:45:06
 * @LastEditTime: 2021-10-12 20:46:30
 * @LastEditors: hz157
 */
class Main{
    public static void main(String args[]){
        Person p1 = new Person("lili",19);
        Person p2 = new Person("lucy",20);
    }
}

class Person{
    private String name;
    private int age;
    public Person(String _name,int _age){
        name = _name;
        age = _age;
        System.out.println("this person is "+ name + ",her age is " + age);
    }
}