/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-21 20:44:09
 * @LastEditTime: 2021-10-21 20:44:09
 * @LastEditors: hz157
 */
class Teacher extends Person{
    String college;
    Teacher(String name, int age, String college) {
        super(name, age);
        this.college=college;
    }
    void work(){
        System.out.println(college);
        System.out.println("教师的工作是教学。");
    }
}