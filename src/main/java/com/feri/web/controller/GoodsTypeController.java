package com.feri.web.controller;

import com.feri.domain.GoodsType;
import com.feri.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:52
 */
@RestController
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService service;

    //查询主页的菜单
    @RequestMapping("goodstypelist.do")
    public List<GoodsType> list(int l){
        return service.queryByLevel(l);
    }
}
