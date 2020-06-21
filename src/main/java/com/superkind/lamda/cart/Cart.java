package com.superkind.lamda.cart;

public class Cart {

    private Integer id;

    private String skuName;

    private Double skuprice;

    private Integer skuTotal;

    private Double totalPrice;

    private Enum skuCateGory;

    public Cart(Integer id, String skuName, Double skuprice, Integer skuTotal, Double totalPrice, Enum skuCateGory) {
        this.id = id;
        this.skuName = skuName;
        this.skuprice = skuprice;
        this.skuTotal = skuTotal;
        this.totalPrice = totalPrice;
        this.skuCateGory = skuCateGory;
    }


    public Integer getId() {
        return id;
    }

    public String getSkuName() {
        return skuName;
    }

    public Double getSkuprice() {
        return skuprice;
    }

    public Integer getSkuTotal() {
        return skuTotal;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Enum getSkuCateGory() {
        return skuCateGory;
    }
}
