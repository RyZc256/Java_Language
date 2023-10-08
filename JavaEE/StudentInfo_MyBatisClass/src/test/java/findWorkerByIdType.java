import com.dao.ClassMapper;
import com.dao.StudentMapper;
import com.poji.Clas;
import com.poji.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class findWorkerByIdType {
    String resources = "mybatis-config.xml";
    Reader reader = null;
    SqlSession session;

    public SqlSession getSession() {
        try {
            reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session = sqlMapper.openSession();
        }catch (
                IOException e){
            e.printStackTrace();
        }
        return session;
    }

    public void findIdStudent(){
        StudentMapper mapper = getSession().getMapper(StudentMapper.class);
        Student student = mapper.selectStudent(2);
        System.out.println(student);
        session.close();
    }

    public void update(){
        StudentMapper mapper = getSession().getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(4);
        student.setName("李雷");
        student.setAge(21);
        int result = mapper.updateStudent(student);
        session.commit();
        if (result>0)
            System.out.println("成功更新" + result + "条数据");
        else
            System.out.println("更新数据失败");
        System.out.println(student);
        session.close();
    }
    public void findClass(){
        ClassMapper mapper = getSession().getMapper(ClassMapper.class);
        Clas calss = mapper.selectClassById(2);
        System.out.println(calss.toString());
        session.close();
    }

    public static void main(String[] args) {
        findWorkerByIdType find = new findWorkerByIdType();
        find.findIdStudent();
        find.update();
        find.findClass();
    }

}
