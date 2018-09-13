package com.feri.service.impl;

import com.feri.domain.City;
import com.feri.domain.County;
import com.feri.domain.Province;
import com.feri.mapper.CityMapper;
import com.feri.mapper.CountyMapper;
import com.feri.mapper.ProvinceMapper;
import com.feri.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:15
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
     @Autowired
    private CityMapper cityMapper;
     @Autowired
    private CountyMapper countyMapper;

    @Override
    public List<Province> queryPro() {
        return provinceMapper.queryAll();
    }

    @Override
    public List<City> queryCity(int pid) {
        return cityMapper.queryByPid(pid);
    }

    @Override
    public List<County> queryCounty(int cid) {
        return countyMapper.queryByCityId(cid);
    }
}
