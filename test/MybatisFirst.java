import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import rj.po.User;

import java.io.InputStream;

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




}
