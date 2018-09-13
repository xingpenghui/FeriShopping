package com.feri.web.controller;

import com.feri.domain.City;
import com.feri.domain.County;
import com.feri.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:17
 */
@RestController
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    //根据省份获取市区
    @RequestMapping("citylist.do")
    public List<City> citys(int pid){
        return service.queryCity(pid);
    }
    //根据市获取县
    @RequestMapping("countylist.do")
    public List<County> countys(int cid){
        return service.queryCounty(cid);
    }


}
