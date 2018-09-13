package com.feri.web.controller;

import com.feri.domain.Cart;
import com.feri.domain.Order;
import com.feri.domain.User;
import com.feri.service.CartItemService;
import com.feri.service.CartService;
import com.feri.service.OrderService;
import com.feri.service.RecAddressService;
import com.feri.vo.OrderPreVo;
import com.feri.vo.OrderVo;
import com.feri.vo.PageVo;
import com.feri.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *@Author feri
 *@Date Created in 2018/8/9 17:07
 */
@RestController
public class OrderController {

    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private RecAddressService recAddressService;
    @Autowired
    private OrderService service;
    //预览
    @RequestMapping("orderpre.do")
    public OrderPreVo pre(String ids, Model model, HttpSession session){
        User user=(User)session.getAttribute("user");
        OrderPreVo orderPreVo=new OrderPreVo();
        orderPreVo.setCartItems(cartItemService.selectByids(ids));
        orderPreVo.setRecAddressess(recAddressService.queryByUid(user.getId()));
        orderPreVo.setItemids(ids);
        return orderPreVo;
    }
    //下单
    @RequestMapping("ordersave.do")
    public R save(int aid, HttpSession session, Model model){
        User user=(User)session.getAttribute("user");
        Cart cart=(Cart)session.getAttribute("cart");
        String ids= (String) session.getAttribute("itemids");
        if(service.createOrder(ids,user.getId(),aid)) {
            return R.ok();
        }else {
            return R.error();
        }
    }
    //订单列表
    @RequestMapping("orderlist.do")
    public PageVo<Order> list(HttpSession session,int page,int limit, Model model){
        User user=(User)session.getAttribute("user");
        return service.queryByUid(user.getId(),page,limit);
    }
    //订单详情
    @RequestMapping("orderdetail.do")
    public OrderVo detail(int oid, Model model){
        return service.queryById(oid);
    }

}
