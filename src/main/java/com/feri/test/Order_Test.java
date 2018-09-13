package com.feri.test;

import com.feri.domain.CartItem;
import com.feri.domain.OrderItem;
import com.feri.mapper.CartItemMapper;
import com.feri.mapper.OrderItemMapper;
import com.feri.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 18:13
 */
public class Order_Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-*.xml");
        CartItemMapper mapper=context.getBean(CartItemMapper.class);
        List<CartItem> itemList=mapper.selectByids("1,2");
//        OrderItemMapper mapper1=context.getBean(OrderItemMapper.class);
//        OrderItem orderItem=new OrderItem();
//        orderItem.setCount(2);
//        orderItem.setMoney((int)(200));
//        orderItem.setOid(1);
//        orderItem.setGid(2);
       // System.out.println(mapper1.insert(orderItem));
        OrderService service=context.getBean(OrderService.class);
//        System.out.println(service.createOrder("1,2",8,1));
//        System.out.println(service.queryByUid(8));
        System.out.println(service.queryById(1));
        //System.out.println(itemList);
    }
}
