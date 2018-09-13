package com.feri.vo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/13 18:55
 */
public class PageVo<T> {
    private int code;
    private String msg;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    private List<T> data;

    public PageVo() {
    }

    public PageVo(int code, String msg,int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count=count;
        this.data = data;
    }

    public PageVo(List<T> data) {
        this.data = data;
    }

    public static <T> PageVo<T> createObj(int count,List<T> list){
        return new PageVo<>(200,"OK",count,list);
    }
    public static <T> PageVo<T> createObjNull(){
        return new PageVo<>(400,"没有数据",0,null);
    }

}
