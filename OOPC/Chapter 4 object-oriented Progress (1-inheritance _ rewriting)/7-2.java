/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-21 20:45:24
 * @LastEditTime: 2021-10-21 20:45:24
 * @LastEditors: hz157
 */
/*
版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
本文链接：https://blog.csdn.net/weixin_53023854/article/details/114678570
————————————————
版权声明：本文为CSDN博主「世界在我口袋」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_53023854/article/details/114678570
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n1= sc.nextInt();
       boolean f=true;
       sc.nextLine();
       ArrayList<PersonOverride> ap=new ArrayList<PersonOverride>();
        for (int i=0;i<n1;i++){
            ap.add(new PersonOverride());
        }
        int n2= sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n2;i++){
            f=true;
            PersonOverride a=new PersonOverride(sc.next(),sc.nextInt(), sc.nextBoolean());
            sc.nextLine();
            for (PersonOverride aa:ap) {
                if (aa.equals(a)){
                    f=false;
                    break;
                }
            }
            if (f)ap.add(a);
        }

        for(PersonOverride a:ap){
            System.out.println(a.toString().replace("[","").replace("]",""));
        }
        System.out.println(ap.size()-n1);
        System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));
    }

}

class PersonOverride{
    private String name;
    private  int age;
    private boolean gender;

    public PersonOverride() {
        this("default",1,true);
    }

    public PersonOverride(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOverride that = (PersonOverride) o;
        return age == that.age &&
                gender == that.gender &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
