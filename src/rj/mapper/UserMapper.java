package rj.mapper;

import rj.po.User;
import rj.po.UserQueryVo;

import java.util.List;
import java.util.Map;

/**
 * Created by 隽 on 2016/12/13.
 */
public interface UserMapper {
    //1、根据用户ID来查询用户信息；
    User findUserById(int id);
    //2、根据用户名称来模糊查询用户信息列表；
    List<User> findUsersByName(String username);
    //3、添加用户
    void insertUser(User user);
    //4、查询符合条件的用户
    List<User> findUserList(UserQueryVo vo);
    //5、根据hashmap查询用户
    List<User> findUserByHashmap(Map map);
    //6、查询所有满足条件的个数
    int findUsersCount(UserQueryVo vo);
    //7、结果别名查询
    User findUserByIdResultMap(int id);
    //8学习动态查询sql片段
    List<User>  findUsersByQueryVO(UserQueryVo vo);
    //9学习动态查询for-each循环
    List<User> findUserByIdList(UserQueryVo vo);
    List<User> findUserByIdList(List list);
}
