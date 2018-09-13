package com.feri.service.impl;

import com.feri.domain.Goods;
import com.feri.mapper.GoodsMapper;
import com.feri.service.GoodsService;
import com.feri.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:50
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Override
    public Goods queryById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public PageVo<Goods> queryByTid(int tid,int page,int limit) {
        return PageVo.createObj(mapper.selectCount(tid),mapper.selectByTid(tid,page,limit));
    }
}
