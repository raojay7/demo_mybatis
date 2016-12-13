package rj.po;

import java.util.List;

/**
 * Created by 隽 on 2016/12/13.
 */
public class UserQueryVo {
    //用户信息
    private User user;

    public User getUser() {
        return user;
    }


    //id集合
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //订单信息

    //商品信息
}
