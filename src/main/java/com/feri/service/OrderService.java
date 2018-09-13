package com.feri.service;

import com.feri.domain.Order;
import com.feri.domain.OrderItem;
import com.feri.vo.OrderVo;
import com.feri.vo.PageVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 17:27
 */
public interface OrderService {
    boolean save(Order order);
    PageVo<Order> queryByUid(int uid,int page,int limit);
    OrderVo queryById(int oid);
    boolean createOrder(String ids, int uid, int aid);
    boolean updateFlag(int oid, int flag);
}
