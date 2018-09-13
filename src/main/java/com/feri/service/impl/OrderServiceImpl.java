package com.feri.service.impl;

import com.feri.domain.CartItem;
import com.feri.domain.Order;
import com.feri.domain.OrderItem;
import com.feri.mapper.CartItemMapper;
import com.feri.mapper.OrderItemMapper;
import com.feri.mapper.OrderMapper;
import com.feri.service.OrderService;
import com.feri.vo.OrderVo;
import com.feri.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 17:48
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Autowired
    private CartItemMapper cartItemMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public boolean save(Order order) {
        return mapper.insert(order)>0;
    }

    @Override
    public PageVo<Order> queryByUid(int uid,int page,int limit) {
        return PageVo.createObj(mapper.selectCount(uid),mapper.selectByUid(uid,page,limit));
    }

    @Override
    public OrderVo queryById(int oid) {
        return mapper.queryById(oid);
    }

    @Override
    public boolean createOrder(String ids, int uid, int aid) {
        try{
            //查询详情---cartitem
            List<CartItem> items=cartItemMapper.selectByids(ids);
            int total=0;
            for(CartItem ci:items){
                total+=ci.getCount()*ci.getGoods().getPrice();
            }
            //新增订单---order
            Order order=new Order();
            order.setAid(aid);
            order.setUid(uid);
            order.setMoney(total);
            mapper.insert(order);
            //新增订单详情--orderitem
            for(CartItem ci:items){
                OrderItem orderItem=new OrderItem();
                orderItem.setCount(ci.getCount());
                orderItem.setMoney((int)(ci.getCount()*ci.getGoods().getPrice()));
                orderItem.setOid(order.getId());
                orderItem.setGid(ci.getGid());
                orderItemMapper.insert(orderItem);
            }
            //删除详情---cartitem
            cartItemMapper.deleteIds(ids);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateFlag(int oid, int flag) {
        return mapper.updateFlag(oid,flag)>0;
    }
}
