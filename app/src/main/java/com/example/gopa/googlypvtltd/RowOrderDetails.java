package com.example.gopa.googlypvtltd;

public class RowOrderDetails {
    private String oid,date,cid,oamt;

    public RowOrderDetails(String oid, String date, String cid,String oamt){
        this.setOid(oid);
        this.setDate(date);
        this.setCid(cid);
        this.setOamt(oamt);
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOamt() {
        return oamt;
    }

    public void setOamt(String oamt) {
        this.oamt = oamt;
    }
}
