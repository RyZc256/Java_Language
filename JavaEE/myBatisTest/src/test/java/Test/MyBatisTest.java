package Test;

import com.itheima.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    public void init(){
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
    public void findAllStudentTest(){
        List<Student> list = sqlSession.selectList("com.itheima.mapper.StudentMapper.findAllStudent");
        for (Student student:list)
            System.out.println(student);
    }
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        MyBatisTest myBatisTest = new MyBatisTest();
        myBatisTest.init();
        myBatisTest.findAllStudentTest();
        myBatisTest.destory();
    }
}
