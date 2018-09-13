package com.feri.mapper;

import com.feri.domain.PayLog;

public interface PayLogMapper {
    int insert(PayLog record);
    int updateByPrimaryKey(PayLog record);
}