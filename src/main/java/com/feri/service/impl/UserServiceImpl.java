package com.feri.service.impl;

import com.feri.domain.Cart;
import com.feri.domain.User;
import com.feri.mapper.CartMapper;
import com.feri.mapper.UserMapper;
import com.feri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/8/2 16:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private CartMapper cartMapper;
    @Override
    public boolean save(User user) {
        boolean r= mapper.insert(user)>0;
        if(r){
            System.out.println("www----->"+user+"---->"+user.getId());
           cartMapper.insert(user.getId());
        }
        return r;
    }

    @Override
    public User login(String name,String pass) {
        User user= mapper.selectByName(name);
        if(user!=null){
            if(Objects.equals(pass,user.getPassword())){
                //成功
                return user;
            }
//            else{
//                //密码不正确
//            }
        }
//        else{
//            //用户名或邮箱不存在
//
//        }
        return null;
    }

    @Override
    public boolean changePass(String pass, int uid) {
        return mapper.updatePassword(pass,uid)>0;
    }

    @Override
    public boolean selectByUserName(String username) {
        Integer id= mapper.selectByUserName(username);
        //com.sun.mail.util.MailLogger mailLogger;
        if(id !=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean selectByEmail(String email) {
        Integer id= mapper.selectByEmail(email);
        if(id !=null){
            return true;
        }else {
            return false;
        }
    }
}
