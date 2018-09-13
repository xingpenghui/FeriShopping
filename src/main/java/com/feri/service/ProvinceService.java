package com.feri.service;

import com.feri.domain.City;
import com.feri.domain.County;
import com.feri.domain.Province;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:14
 */
public interface ProvinceService {
    //查询省份
    List<Province> queryPro();
    //查询市区
    List<City> queryCity(int pid);
    //查询区/县
    List<County> queryCounty(int cid);
}
