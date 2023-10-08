package com.poji;

import java.util.List;

public class Product {
    private int id;
    private String goodsName;
    private double price;
    private int typeId;


    public int getId() {
        return id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getPrice() {
        return price;
    }

    public int getTypeId() {
        return typeId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", typeId=" + typeId +
                '}';
    }
}
