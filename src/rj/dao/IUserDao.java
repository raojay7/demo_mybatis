package rj.dao;

import rj.po.User;

import java.util.List;

/**
 * Created by 隽 on 2016/12/13.
 */
public interface IUserDao {
    //1、根据用户ID来查询用户信息；
    User findUserById(int id);
    //2、根据用户名称来模糊查询用户信息列表；
    List<User> findUserByName(String name);
    //3、添加用户
    void insertUser(User user);
}
