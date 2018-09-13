package com.feri.service.impl;

import com.feri.domain.GoodsType;
import com.feri.mapper.GoodsTypeMapper;
import com.feri.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:51
 */
@Service
public class GoodsTypeImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper mapper;
    @Override
    public List<GoodsType> queryByLevel(int l) {
        return mapper.selectAll(l);
    }
}
