package com.feri.mapper;


import com.feri.domain.GoodsType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsTypeMapper {
    @Select("select * from t_goodstype where level =#{level}")
    @ResultType(GoodsType.class)
    List<GoodsType> selectAll(int level);
}