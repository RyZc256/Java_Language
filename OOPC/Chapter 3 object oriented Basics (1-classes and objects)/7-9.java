/*
 * @Description: 7-9
 * @Author: hz157
 * @Date: 2021-10-12 20:45:56
 * @LastEditTime: 2021-10-12 20:45:56
 * @LastEditors: hz157
 */
 public class Main {
    public static void main(String[] args) {
        Person[] p = new Person[3];
        p[0] = new Person("zhangsan",18);
        p[1] = new Person("lisi",20);
        p[2] = new Person("wangwu",22);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getName() + " " + p[i].getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
