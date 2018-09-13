package com.feri.mapper;

import com.feri.domain.RecAddress;

import java.util.List;

public interface RecAddressMapper {

    int insert(RecAddress record);
    //地址显示为名称
    List<RecAddress> queryByUid(int uid);
    int updateById(RecAddress address);



}