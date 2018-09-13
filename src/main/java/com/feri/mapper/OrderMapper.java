package com.feri.mapper;

import com.feri.domain.Order;
import com.feri.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int insert(Order record);

    Order selectById(Integer id);

    int updateFlag(@Param("oid") int oid, @Param("flag") int flag);

    List<Order> selectByUid(@Param("uid") int uid,@Param("page") int page,@Param("limit") int limit);
    int selectCount(int uid);

    OrderVo queryById(int oid);
}