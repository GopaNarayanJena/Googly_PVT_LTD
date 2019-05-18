package com.example.gopa.googlypvtltd;

public class RowQuery1 {
    private String cname,noo,avg;

    public RowQuery1(String cname, String noo, String avg) {
        this.cname = cname;
        this.noo = noo;
        this.avg = avg;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getNoo() {
        return noo;
    }

    public void setNoo(String noo) {
        this.noo = noo;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
}
