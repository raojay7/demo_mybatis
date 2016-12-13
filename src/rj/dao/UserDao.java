package rj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import rj.po.User;

import java.util.List;

/**
 * 原始方法开发dao
 * 但是不推荐
 * 后面的spring可以用模板（aop）解决一些打开关闭的问题
 * 现在当前写好的dao不能直接用，没有注入sqlsessionfactory
 *  总结存在的问题
 *  	存在一定量的模板代码。比如：通过SqlSessionFactory创建SqlSession；调用SqlSession的方法操作数据库；关闭Sqlsession。
 *  	存在一些硬编码。调用SqlSession的方法操作数据库时，需要指定statement的id，这里存在了硬编码。
 * Created by 隽 on 2016/12/13.
 */
public class UserDao implements IUserDao{
    //根据前面简单的实现，我们知道，有大段的重复代码
    //核心的代码就是sqlsession的操作，而不是频繁的创建关闭
    //由此可以想到用全局单例工厂，但是自己不好管理
    //所以交给spring管理
    //进行依赖注入
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {
        //开启sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("findUserById", 1);


        //打印输出结果集
        System.out.println(user);

        //5、关闭SqlSession
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list=sqlSession.selectList("findUsersByName","小明");


        //打印输出结果集
        System.out.println(list);

        //5、关闭SqlSession
        sqlSession.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、SqlSession执行statement
        user.setUsername("4444");
        user.setAddress("6666");

        sqlSession.insert("insertUser",user);

        sqlSession.commit();

        //5、关闭SqlSession
        sqlSession.close();
    }
}
