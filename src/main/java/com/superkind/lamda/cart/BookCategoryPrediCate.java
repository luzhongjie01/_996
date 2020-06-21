package com.superkind.lamda.cart;

public class BookCategoryPrediCate implements  PrediCate{
    @Override
    public Boolean test(Cart cart) {
        return cart.getSkuCateGory().equals(SkuCateGoryEnum.BOOKCLASS);
    }
}
