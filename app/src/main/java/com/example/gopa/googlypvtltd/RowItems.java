package com.example.gopa.googlypvtltd;

public class RowItems {
    private String id,price;

    public RowItems(String id, String price){
        this.setId(id);
        this.setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
