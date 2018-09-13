package com.feri.service;

import com.feri.domain.RecAddress;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:40
 */
public interface RecAddressService {
    //新增
    boolean save(RecAddress address);
    //查询
    List<RecAddress> queryByUid(int uid);

}
