package com.feri.service;

import com.feri.domain.GoodsType;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:50
 */
public interface GoodsTypeService {
    List<GoodsType> queryByLevel(int l);
}
