package com.feri.vo;

import com.feri.domain.CartItem;
import com.feri.domain.RecAddress;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/13 19:11
 */
public class OrderPreVo {
    private List<CartItem> cartItems;
    private List<RecAddress> recAddressess;
    private String itemids;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<RecAddress> getRecAddressess() {
        return recAddressess;
    }

    public void setRecAddressess(List<RecAddress> recAddressess) {
        this.recAddressess = recAddressess;
    }

    public String getItemids() {
        return itemids;
    }

    public void setItemids(String itemids) {
        this.itemids = itemids;
    }
}
