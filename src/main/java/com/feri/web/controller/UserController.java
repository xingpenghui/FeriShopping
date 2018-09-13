package com.feri.web.controller;

import com.feri.common.util.EmailUtils;
import com.feri.common.util.RandomUtils;
import com.feri.domain.User;
import com.feri.service.CartService;
import com.feri.service.UserService;
import com.feri.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 *@Author feri
 *@Date Created in 2018/8/2 16:42
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @Autowired
    private CartService cartService;
    //注册
    @PostMapping("usersave.do")
    public R register(User user, Model model){
        //设置激活码
        user.setActivecode(RandomUtils.createActive());
        user.setFlag(0);

        if(service.save(user)){

            EmailUtils.sendEmail(user);
            //成功
            return R.ok();
        }else{
            //失败
            model.addAttribute("msg","注册失败请稍后再试！");
            return R.error();
        }
    }
    //登录
    @PostMapping("userlogin.do")
    public R login(String name, String password, HttpSession session,Model model){
        User user=service.login(name,password);
       if(user==null){
           model.addAttribute("msg","用户名或密码错误");
           return R.error();
       }else{
           session.setAttribute("user",user);
           session.setAttribute("cart",cartService.queryById(user.getId()));
           return R.ok();
       }
    }
    //注销
    @GetMapping("userloginout.do")
    public R loginout(HttpSession session){
        session.removeAttribute("user");
        return R.ok();
    }

    //验证用户名是否存在
    @GetMapping("username.do")
    public R checkName(String username){
        if(service.selectByUserName(username)){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //验证邮箱是否存在
    @GetMapping("useremail.do")
    public R checkEmail(String email){
        if(service.selectByEmail(email)){
            return R.ok();
        }else {
            return R.error();
        }
    }
    //检查是否登录
    @RequestMapping("userlogincheck.do")
    public R checkLogin(HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user!=null){
            return new R(0,"成功",user);
        }else {
            return R.error();
        }
    }
}
