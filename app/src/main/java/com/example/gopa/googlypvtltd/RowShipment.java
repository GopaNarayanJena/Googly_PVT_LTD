package com.example.gopa.googlypvtltd;

public class RowShipment {
    private String oid,wid,sdate;

    public RowShipment(String oid, String wid, String sdate) {
        this.oid = oid;
        this.wid = wid;
        this.sdate = sdate;
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
}
