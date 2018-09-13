package com.feri.mapper;

import com.feri.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {
    @Select("select id,name, tid, pubdate, dowdate, createtime, price, star, picurl, flag, uid, info  from t_goods where id=#{id}")
    @ResultType(Goods.class)
    Goods selectById(Integer id);

    @Select("select g.*,gt.name typename  from t_goods g left join t_goodstype gt on g.tid=gt.id where g.tid=#{tid} order by g.id limit #{page},#{limit}")
    @ResultType(Goods.class)
    List<Goods> selectByTid(@Param("tid") int tid, @Param("page") int page, @Param("limit") int limit);

    @Select("select count(*) from t_goods where tid=#{tid}")
    @ResultType(int.class)
    int selectCount(int tid);




}