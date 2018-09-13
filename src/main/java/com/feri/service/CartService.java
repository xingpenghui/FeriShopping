package com.feri.service;

import com.feri.domain.Cart;

/**
 *@Author feri
 *@Date Created in 2018/8/7 17:29
 */
public interface CartService {
    boolean save(int uid);
    Cart queryById(int uid);
}
