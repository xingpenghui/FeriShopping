package com.feri.mapper;

import com.feri.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int insert(OrderItem record);


}