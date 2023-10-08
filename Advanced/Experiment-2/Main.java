import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("==========================new==============================");
        Teacher T1 = new SqlTeacher("张三","厦门理工学院");
        T1.course();
        T1.introduce();

        System.out.println("==========================反射==============================");

        // 有参构造
        Constructor con1 = JavaTeacher.class.getConstructor(String.class,String.class);
        JavaTeacher T2 = (JavaTeacher) con1.newInstance("李四","厦门大学");
        T2.course();
        T2.introduce();

//         无参构造
//        Class JavaTeacherClass = Class.forName("JavaTeacher");
//        JavaTeacher T3 = (JavaTeacher) JavaTeacherClass.newInstance();


        Teacher T3 = new SqlTeacher("赵四","厦门大学",new ColorPrint());
        T3.course();
        T3.introduce();
        Teacher T4 = new SqlTeacher("刘五","福州大学",new BlackPrint());
        T4.course();
        T4.introduce();

    }
}

class Teacher {
    private String name;
    private String school;

    public Teacher(String data_1,String data_2){
        this.name = data_1;
        this.school = data_2;
    }

    public Teacher(String data_1, String data_2, print data_3){
        this.name = data_1;
        this.school = data_2;
    }

    public void course(){
        System.out.println("授课");
    }

    public void introduce(){
        System.out.println(String.format("自我介绍-姓名:%s,学校:%s",this.name,this.school));
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

class JavaTeacher extends Teacher {

    public JavaTeacher(String name, String school, print printmechine) {
        super(name, school,printmechine);
    }
    public JavaTeacher(String name, String school) {
        super(name, school);
    }

    public void course() {
        System.out.println("打开Eclipse、实施理论课授课");
    }
}


class SqlTeacher extends Teacher {

    public SqlTeacher(String name, String school, print printmechine){
        super(name,school,printmechine);
    }
    public SqlTeacher(String name,String school){
        super(name,school);
    }

    public void course(){
        System.out.println("打开SQL Server Management Studio、实施理论课授课");
    }
}


