package rj.po;

/**
 * Created by 隽 on 2017/3/15.
 */
public class OrdersExt extends Orders
{
//    user.username
//    user.address
    public String username;
    public String address;
    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


}
