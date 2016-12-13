import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import rj.mapper.UserMapper;
import rj.po.User;
import rj.po.UserQueryVo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    //测试符合条件的个数和查询的结果
    @Test
    public void findUserListTest(){


        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo=new UserQueryVo();
        User u=new User();
        u.setSex(1);
        u.setUsername("小明");
        vo.setUser(u);
        //List<User> list=mapper.findUserList(vo);
        //调用动态查询
        List<User> list=mapper.findUsersByQueryVO(vo);
        int count=mapper.findUsersCount(vo);
        System.out.println(list);
        System.out.println(count);

        sqlSession.close();
    }
    @Test
    public void findUserByHashmapTest(){


        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map=new HashMap();
        map.put("username","哥");
        List<User> list=mapper.findUserByHashmap(map);
        System.out.println(list);
        sqlSession.close();
    }
    @Test
    public void findUserByIdResultMapTest(){


        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u=mapper.findUserByIdResultMap(1);
        System.out.println(u);
        sqlSession.close();
    }

    @Test
    public void findUserByIdListTest(){


        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 由mybatis通过sqlsession来创建代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(10);
        idList.add(16);
        //UserQueryVo vo=new UserQueryVo();
        //vo.setIdList(idList);
        //List<User> list=mapper.findUserByIdList(vo);
        List<User> list=mapper.findUserByIdList(idList);
        System.out.println(list);
        sqlSession.close();

    }


}
