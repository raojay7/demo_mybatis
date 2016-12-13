import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import rj.mapper.UserMapper;
import rj.po.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 隽 on 2016/12/13.
 */
public class MapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        // 读取配置文件
        // 全局配置文件的路径
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void findUserByIdTest(){
        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u=mapper.findUserById(27);
        System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void insertUserTest(){

        User u=new User();
        u.setAddress("33232332");
        u.setSex(1);
        u.setUsername("小黑");
        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(u);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void findByNameTest(){


        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list=mapper.findUsersByName("小明");
        System.out.println(list);
        sqlSession.close();
    }

}
