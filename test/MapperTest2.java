import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import rj.mapper.OrdersMapper;
import rj.po.Orders;
import rj.po.OrdersExt;
import rj.po.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 隽 on 2017/3/15.
 */
public class MapperTest2
{
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
    public void findOrdersUserTest()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersExt> list=mapper.findOrdersUser();

        for (OrdersExt oe:list)
        {
            System.out.println(oe);
        }

        sqlSession.close();

    }


    @Test
    public void findOrdersUserRstMapTest()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list=mapper.findOrdersUserRstMap();

        for (Orders o:list)
        {
            System.out.println(o);
        }

        sqlSession.close();

    }

    @Test
    public void findOrdersAndOrderdetailRstMapTest()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list=mapper.findOrdersAndOrderdetailRstMap();

        for (Orders o:list)
        {
            System.out.println(o);
        }

        sqlSession.close();

    }


    @Test
    public void findUserAndItemsRstMapTest()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> list=mapper.findUserAndItemsRstMap();

        for (User u:list)
        {
            System.out.println(u);
        }

        sqlSession.close();

    }

    @Test
    public void findOrderAndUserLazyLoadingTest()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersExt> list=mapper.findOrderAndUserLazyLoading();

        for (OrdersExt oe:list)
        {
            System.out.println(oe.getUser());
        }

        sqlSession.close();

    }

}
