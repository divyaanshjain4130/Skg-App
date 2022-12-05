package com.example.skg.models;

public class order_model {
    int orderImage;
    String quant ,phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    int phone;s
    String orderName;
    String price;
    String orderDesc;
    String orderNumb,name,loc;


    public String getOrderNumb() {
        return orderNumb;
    }

    public void setOrderNumb(String orderNumb) {
        this.orderNumb = orderNumb;
    }

    public order_model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public order_model(int orderImage , String orderName, String price, String orderDesc, String name, String loc, String quant,String phone) {
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.price = price;
        this.orderDesc = orderDesc;
        this.loc=loc;
        this.name=name;
        this.quant=quant;
        this.phone=phone;
    }
    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderNumber) {
        this.orderDesc = orderDesc;
    }
}
