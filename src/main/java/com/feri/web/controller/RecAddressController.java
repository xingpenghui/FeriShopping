package com.feri.web.controller;

import com.feri.domain.RecAddress;
import com.feri.domain.User;
import com.feri.service.ProvinceService;
import com.feri.service.RecAddressService;
import com.feri.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/9 11:42
 */
@RestController
public class RecAddressController {
    @Autowired
    private RecAddressService service;
    @Autowired
    private ProvinceService provinceService;

    //新增
    @RequestMapping("addresssave.do")
    public R save(RecAddress address,HttpSession session){
        User user= (User) session.getAttribute("user");
        address.setUid(user.getId());
        if(service.save(address)){
            return R.ok();
        }else {
            return R.error();
        }
    }
    //查询
    @RequestMapping("addresslist.do")
    public List<RecAddress> list(HttpSession session, Model model){
        User user= (User) session.getAttribute("user");
//        model.addAttribute("addresslist",service.queryByUid(user.getId()));
       // model.addAttribute("provinces",provinceService.queryPro());

        return service.queryByUid(user.getId());
    }
}
