package com.feri.web.controller;

import com.feri.common.pay.PayCommonUtil;
import com.feri.common.pay.PayConfig;
import com.feri.common.pay.XmlUtil;
import com.feri.common.pay.ZxingUtil;
import com.feri.domain.Order;
import com.feri.service.OrderService;
import com.feri.vo.R;
import org.apache.ibatis.annotations.Param;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 *@Author feri
 *@Date Created in 2018/8/10 12:24
 */
@Controller
public class PayController {

    @Autowired
    private OrderService service;

    //获取支付url
    @RequestMapping("paypre.do")
    @ResponseBody
    public R prePay(@RequestParam(defaultValue = "1001") int oid, String price, HttpSession session) throws Exception {

        String url=PayCommonUtil.weixin_pay(price,"测试商品",PayCommonUtil.getCurrTime()+"_"+oid);
        session.setAttribute("payurl",url);
        return R.ok();
    }
    //生成字符的二维码
    @RequestMapping("payimage.do")
    public void createzxing(HttpSession session, HttpServletResponse response) throws IOException {
        String url= (String) session.getAttribute("payurl");
        BufferedImage image=ZxingUtil.createImage(url,200,200);
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }
    //支付结果异步通知
    @RequestMapping("paycallback.do")
    public void callback(HttpServletRequest request) throws IOException, JDOMException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuffer buffer=new StringBuffer();
        String m;
        while ((m=reader.readLine())!=null){
            buffer.append(m);
        }
        reader.close();
        Map<String,String> params=XmlUtil.doXMLParse(buffer.toString());
        //验签
        TreeMap<String,String> map=new TreeMap<>();
        for (String k:params.keySet()){
            String v=params.get(k);
            if(v!=null && v.length()>0) {
                map.put(k, v);
            }
        }
        //字典顺序排序  排除空参
        //延签
        if(PayCommonUtil.isTenpaySign("UTF-8",map,PayConfig.API_KEY)){
            if(map.get("return_code").equals("SUCCESS")){
                //返回成功
                if(map.get("result_code").equals("SUCCESS")){
                    //支付成功
                    //更改数据库的订单的支付状态
                    service.updateFlag(Integer.parseInt(map.get("out_trade_no")),1);
                    System.err.println("订单："+map.get("out_trade_no")+"---支付成功：支付金额："+map.get("cash_fee"));
                }
            }
        }





    }
}
