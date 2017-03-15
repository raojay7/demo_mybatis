package rj.mapper;

import rj.po.Orders;
import rj.po.OrdersExt;
import rj.po.User;

import java.util.List;

/**
 * Created by 隽 on 2016/12/13.
 */
public interface OrdersMapper
{
    //	进行订单信息查询，包括用户的名称和地址信息
    public List<OrdersExt> findOrdersUser();

    //	进行订单信息查询，包括用户的名称和地址信息（resultMap）
    public List<Orders> findOrdersUserRstMap();

    // 查询订单信息及订单明细信息（一对多映射之使用resultMap）
    public List<Orders> findOrdersAndOrderdetailRstMap();

    //查询用户及用户购买商品信息（多对多映射之使用resultMap）
    public List<User> findUserAndItemsRstMap();

    //使用懒加载
    List<OrdersExt> findOrderAndUserLazyLoading();
}
