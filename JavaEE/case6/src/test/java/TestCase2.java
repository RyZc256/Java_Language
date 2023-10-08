package test.java;

import com.case1.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("case2/applicationContext.xml");
        UserDao userDao=context.getBean("userDao",UserDao.class);
        userDao.delete();
        System.out.println();
        userDao.insert();
        System.out.println();
        userDao.update();
        System.out.println();
        userDao.select();
        System.out.println();
    }
}
