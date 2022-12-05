package com.example.skg.models;

public class main_model {
    int orderImage;
    String orderName;
    String price;
    String orderDesc;
    String orderNumb;


    public main_model(int orderImage, String orderName, String price, String orderDesc) {
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.price = price;
        this.orderDesc = orderDesc;
//        this.orderNumb = orderNumb;
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

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getOrderNumb() {
        return orderNumb;
    }

    public void setOrderNumb(String orderNumb) {
        this.orderNumb = orderNumb;
    }

}
