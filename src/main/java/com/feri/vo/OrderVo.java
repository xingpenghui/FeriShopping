package com.feri.vo;

import com.feri.domain.Goods;
import com.feri.domain.Order;
import com.feri.domain.OrderItem;
import com.feri.domain.RecAddress;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 17:30
 */
public class OrderVo {
    private Order order;
    private List<OrderItem> orderItems;
    private RecAddress address;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public RecAddress getAddress() {
        return address;
    }

    public void setAddress(RecAddress address) {
        this.address = address;
    }
}
