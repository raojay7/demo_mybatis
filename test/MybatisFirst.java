import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import rj.po.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 隽 on 2016/12/7.
 */
public class MybatisFirst {
    @Test
    public void findUserByIdTest() throws Exception{

        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、SqlSession执行statement，并返回映射结果
        //第一个参数：statement的id，建议：namespace.statementId（确保唯一）
        //第二个参数：入参的值，它的类型要和映射文件中对应的statement的入参类型一致
        User user = sqlSession.selectOne("findUserById", 1);


        //打印输出结果集
        System.out.println(user);

        //5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findUsersByNameTest()throws Exception{

        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、SqlSession执行statement，并返回映射结果
        List<User> list=sqlSession.selectList("findUsersByName","小明");


        //打印输出结果集
        System.out.println(list);

        //5、关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void insertUserTest()throws Exception {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、SqlSession执行statement
        User user = new User();
        user.setUsername("2222");
        user.setAddress("aaa");

        sqlSession.insert("insertUser",user);

        //切记：增删改操作后要commit
        sqlSession.commit();



        //5、关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void updateanddeleteTest()throws Exception {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、SqlSession执行statement


        /**********测试更新**********/

       /* User user = new User();
        user.setUsername("3333");
        user.setAddress("abbb");
        user.setId(28);
        sqlSession.update("updateUser",user);

        */

        /**********测试删除*************/
        sqlSession.delete("deleteUser",29);
        //切记：增删改操作后要commit
        sqlSession.commit();



        //5、关闭SqlSession
        sqlSession.close();
    }
}
