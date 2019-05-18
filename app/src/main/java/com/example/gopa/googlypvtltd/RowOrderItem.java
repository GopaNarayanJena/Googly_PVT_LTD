package com.example.gopa.googlypvtltd;

public class RowOrderItem {
    private String oid,iid,qty;

   RowOrderItem(String oid,String iid,String qty){
       this.setOid(oid);
       this.setIid(iid);
       this.setQty(qty);
   }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
