package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer id;
    private String  goodsname;
    private Integer number;
    private Integer price;
    private Integer goodid;
    private Integer uid;

    private List<Goods> goodsList = new ArrayList<Goods>();

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", goodid=" + goodid +
                ", uid=" + uid +
                '}';
    }
}
