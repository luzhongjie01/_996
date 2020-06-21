package com.superkind.lamda.cart;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl {
    private static List<Cart> carts = new ArrayList<Cart>();

    static {
        carts.add(new Cart(1, "手机", 3000.0, 1, 3000.0, SkuCateGoryEnum.DIGITALCLASS));
        carts.add(new Cart(2, "金字塔原理", 1500.0, 1, 1500.0, SkuCateGoryEnum.BOOKCLASS));
        carts.add(new Cart(3, "跑步机", 3000.0, 1, 3000.0, SkuCateGoryEnum.SPORTS));
        carts.add(new Cart(4, "牛仔裤", 1000.0, 1, 1000.0, SkuCateGoryEnum.CLOTHING));
        carts.add(new Cart(5, "卫衣", 3000.0, 1, 3000.0, SkuCateGoryEnum.CLOTHING));
    }


    public static List<Cart> getCarts() {
        return carts;
    }


    /**
     * 过滤查询出图书类型的商品
     *
     * @param carts
     * @return
     */
    public static List<Cart> filterBookClassCart(List<Cart> carts) {
        List<Cart> list = new ArrayList<Cart>();
        for (Cart cart : carts) {
            if (SkuCateGoryEnum.BOOKCLASS.equals(cart.getSkuCateGory())) {
                list.add(cart);
            }
        }
        return list;
    }


    /**
     * 根据商品类型过滤购物车中数据
     *
     * @param carts
     * @param skuCateGoryEnum
     * @return
     */
    public static List<Cart> filterByCategory(List<Cart> carts, SkuCateGoryEnum skuCateGoryEnum) {
        List<Cart> list = new ArrayList<Cart>();
        for (Cart cart : carts) {
            if (skuCateGoryEnum.equals(cart.getSkuCateGory())) {
                list.add(cart);
            }
        }
        return list;
    }

    public static List<Cart> filterByCategoryOrTotalPrice(List<Cart> carts, SkuCateGoryEnum skuCateGoryEnum, Double toalPrice, Boolean categoryOrTotalPrice) {
        List<Cart> list = new ArrayList<Cart>();
        for (Cart cart : carts) {
            if (categoryOrTotalPrice && skuCateGoryEnum.equals(cart.getSkuCateGory())
                    ||
                    !categoryOrTotalPrice && cart.getTotalPrice() >= toalPrice
            ) {
                list.add(cart);
            }
        }
        return list;
    }


    public static  List<Cart> filterByPrediCate(List<Cart> carts,PrediCate prediCate){
        List<Cart> list = new ArrayList<Cart>();
        for (Cart cart : carts) {
            if(prediCate.test(cart)){
                list.add(cart);
            }
        }
        return list;
    }


}
