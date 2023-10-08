package Test;

import com.info.ent.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;

public class StudentTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public StudentTest(){
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlMapper.openSession();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void findName(){
        Student student = new Student();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        student.setS_name(input.nextLine());
        System.out.println("请输入学生专业：");
        student.setS_profession(input.nextLine());
        List<Student> list = sqlSession.selectList("mapper.StudentMapper.findStudent",student);
        for (Student i:list)
            System.out.println(i);
    }
    public void find5(){
        List<Student> list = sqlSession.selectList("mapper.StudentMapper.find5");
        for (Student i:list)
            System.out.println(i);
    }

    public static void main(String[] args) {
        StudentTest test = new StudentTest();
        test.findName();
        test.find5();
    }
}
