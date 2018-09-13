package com.feri.service;

import com.feri.domain.User;

/**
 *@Author feri
 *@Date Created in 2018/8/2 16:38
 */
public interface UserService {

    boolean save(User user);
    User login(String name, String pass);
    boolean changePass(String pass, int uid);
    boolean selectByUserName(String username);
    boolean selectByEmail(String email);

}
