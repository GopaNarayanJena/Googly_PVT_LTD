package com.example.gopa.googlypvtltd;

public class RowCustomer {
    private String id,name,city;

    public RowCustomer(String id, String name, String city){
        this.setId(id);
        this.setName(name);
        this.setCity(city);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
