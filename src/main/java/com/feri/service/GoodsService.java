package com.feri.service;

import com.feri.domain.Goods;
import com.feri.vo.PageVo;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:49
 */
public interface GoodsService {
    Goods queryById(int id);
    PageVo<Goods> queryByTid(int tid,int page,int limit);

}
