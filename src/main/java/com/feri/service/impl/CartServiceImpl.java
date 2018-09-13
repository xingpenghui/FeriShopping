package com.feri.service.impl;

import com.feri.domain.Cart;
import com.feri.mapper.CartMapper;
import com.feri.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/8/7 17:31
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper mapper;
    @Override
    public boolean save(int uid) {
        return mapper.insert(uid)>0;
    }

    @Override
    public Cart queryById(int uid) {
        return mapper.selectByUid(uid);
    }
}
