package com.feri.service;

import com.feri.domain.CartItem;
import com.feri.vo.PageVo;
import com.feri.vo.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/7 17:30
 */
public interface CartItemService {
    int deleteById(Integer id);
    int deleteByCid(Integer cid);
    boolean save(CartItem record);
    boolean saveOrUpdate(int cid, int gid);
    R changeNum(int num, int id);
    //只负责修改
    int updateById(int id, int count);

    List<CartItem> selectByids(String ids);
    List<CartItem> queryByCid(Integer cid);
    //PageVo<CartItem> queryByCid(Integer cid,int page,int limit);
}
