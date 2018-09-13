package com.feri.service.impl;

import com.feri.domain.RecAddress;
import com.feri.mapper.RecAddressMapper;
import com.feri.service.RecAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:41
 */
@Service
public class RecAddressImpl implements RecAddressService {
    @Autowired
    private RecAddressMapper mapper;
    @Override
    public boolean save(RecAddress address) {
        return mapper.insert(address)>0;
    }

    @Override
    public List<RecAddress> queryByUid(int uid) {
        return mapper.queryByUid(uid);
    }
}
