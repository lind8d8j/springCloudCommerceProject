package com.entity;

public class Userorder {
    public int id,number,price;
    public String goodsname,time;
    private Integer uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Userorder{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", goodsname='" + goodsname + '\'' +
                ", time='" + time + '\'' +
                ", uid=" + uid +
                '}';
    }
}
