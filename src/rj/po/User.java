package rj.po;

import java.util.Date;
import java.util.List;

/**
 * pojo类
 * Created by 隽 on 2016/12/7.
 */
public class User {
    private int id;
    private String username;
    private Date birthday;
    private int sex;//1为男
    private String address;
    // 订单信息
    private List<Orders> ordersList;

    public List<Orders> getOrdersList()
    {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList)
    {
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}

