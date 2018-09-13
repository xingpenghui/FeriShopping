package com.feri.web.controller;

import com.feri.domain.Goods;
import com.feri.service.GoodsService;
import com.feri.service.GoodsTypeService;
import com.feri.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 11:52
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService service;
    //查询商品列表
    @RequestMapping("goodsbytid.do")
    public PageVo<Goods> list(@RequestParam(defaultValue = "0") int tid,int page,int limit, Model model){
       return service.queryByTid(tid,page,limit);
    }
    //查询商品详情
    @RequestMapping("goodsbyid.do")
    public Goods single(int id,Model model){
        return service.queryById(id);
    }

}
