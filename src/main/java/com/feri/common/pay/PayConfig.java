package com.feri.common.pay;

/**
 *@Author feri
 *@Date Created in 2018/8/9 22:58
 */
public class PayConfig {
    public static String APP_ID = "wx632c8f211f8122c6";
    public static String MCH_ID = "1497984412";
    public static String API_KEY = "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    public static String UFDOOER_URL =
            "https://api.mch.weixin.qq.com/pay/unifiedorder";//下单接口
    public static String QUERY_URL =
            "https://api.mch.weixin.qq.com/pay/orderquery";//查询接口

    public static String NOTIFY_URL = "http://pic.chenjunbo.xin/payment/result";
    public static String CREATE_IP = "114.242.26.51";

}
