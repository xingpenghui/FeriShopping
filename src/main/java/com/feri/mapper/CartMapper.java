package com.feri.mapper;

import com.feri.domain.Cart;

public interface CartMapper {
    int insert(int uid);
    Cart selectByUid(Integer uid);
}