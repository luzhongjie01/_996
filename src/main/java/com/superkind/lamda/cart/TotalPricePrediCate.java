package com.superkind.lamda.cart;

public class TotalPricePrediCate implements  PrediCate {
    @Override
    public Boolean test(Cart cart) {
        return cart.getTotalPrice() >= 2000;
    }
}
