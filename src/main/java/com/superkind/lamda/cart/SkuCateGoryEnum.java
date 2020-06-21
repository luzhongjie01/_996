package com.superkind.lamda.cart;

public enum SkuCateGoryEnum {
    DIGITALCLASS(1,"数码类"),
    CLOTHING(2,"服装类"),
    SPORTS(3,"运动类"),
    BOOKCLASS(4,"图书类");


    private Integer code;

    private String name;

    SkuCateGoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
