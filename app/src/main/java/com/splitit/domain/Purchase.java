package com.splitit.domain;

import java.util.Date;

public class Purchase {
    private long ID;
    private String purchaseName;
    private int price;
    private Date date;

    public Purchase(long ID, String purchaseName, int price, Date date) {
        this.ID = ID;
        this.purchaseName = purchaseName;
        this.price = price;
        this.date = date;
    }

    public Purchase(String purchaseName, int price) {
        this.purchaseName = purchaseName;
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "ID=" + ID +
                ", purchaseName='" + purchaseName + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
