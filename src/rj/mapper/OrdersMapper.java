package rj.mapper;

import rj.po.Orders;
import rj.po.OrdersExt;

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

}
