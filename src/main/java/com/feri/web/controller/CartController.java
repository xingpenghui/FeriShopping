package com.feri.web.controller;

import com.feri.domain.Cart;
import com.feri.domain.CartItem;
import com.feri.service.CartItemService;
import com.feri.vo.PageVo;
import com.feri.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 17:38
 */
@RestController
public class CartController {

    @Autowired
    private CartItemService service;

    //添加购物车
    @RequestMapping("cartsave.do")
    public R save(int gid, HttpSession session){
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart!=null) {
            if (service.saveOrUpdate(cart.getId(),gid)){
                return R.ok();
            }
        }
        return R.error();
    }
    //改变数量
    @GetMapping("cartupdate.do")
    @ResponseBody
    public R changeNum(int num,int id){
        return service.changeNum(num,id);
    }
    //删除
    @GetMapping("cartdel.do")
    public R del(HttpSession session){
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart!=null){
            if(service.deleteByCid(cart.getId())>0){
               return R.ok();
            }
        }
        return R.error();
    }
    //查询购物车详情
    @RequestMapping("cartlist.do")
    public List<CartItem> list(HttpSession session, Model model){
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart!=null) {
            return service.queryByCid(cart.getId());
        }else {
            return new ArrayList<>();
        }
    }
}
