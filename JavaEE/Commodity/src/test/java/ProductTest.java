import com.poji.Category;
import com.poji.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ProductTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public ProductTest(){
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

    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }

    public void findAllStudentTest(){
        List<Category> list = sqlSession.selectList("mapper.ProductMapper.findType",2);
        for (Category category:list)
            System.out.println(category);
    }

    public static void main(String[] args) {
        ProductTest productTest = new ProductTest();
        productTest.findAllStudentTest();
        productTest.destory();
    }
}
