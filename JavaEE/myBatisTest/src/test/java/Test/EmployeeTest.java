package Test;

import com.itheima.pojo.Employee;
import com.itheima.pojo.Student;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class EmployeeTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public void init(){
        String resources = "mybatis-config.xml";
        Reader reader=null;
        try{
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
    }
    public void find(Employee employee){
        employee = sqlSession.selectOne("com.itheima.mapper.EmployeeMapper.find",employee);
        System.out.println(employee);
//        sqlSession.close();
    }

    public void del(Employee employee){
        employee = sqlSession.selectOne("com.itheima.mapper.EmployeeMapper.del",employee);
        System.out.println(employee);
//        sqlSession.close();
    }

    public void add(Employee employee){
        employee = sqlSession.selectOne("com.itheima.mapper.EmployeeMapper.add",employee);
        System.out.println(employee);
//        sqlSession.close();
    }

    public void update(Employee employee){
        employee = sqlSession.selectOne("com.itheima.mapper.EmployeeMapper.update",employee);
        System.out.println(employee);
//        sqlSession.close();
    }


    public static void main(String[] args) {
        // 用于查询和删除的对象
        Employee find = new Employee();
        find.setId(4);
        // 用于添加的对象
        Employee add = new Employee("赵四",20,"员工");
        // 供修改的对象
        Employee edit = new Employee(4,"赵四",20,"老板");
        // 创建对象
        EmployeeTest employeeTest = new EmployeeTest();
        // 初始化myBatis
        employeeTest.init();
        // 执行添加函数
//        employeeTest.add(add);
        // 执行查找函数
        employeeTest.find(edit);
        // 执行修改函数
        employeeTest.update(edit);
        //      执行查找函数
        employeeTest.find(edit);
        // 执行删除函数
        employeeTest.del(find);
        employeeTest.find(edit);
    }
}
