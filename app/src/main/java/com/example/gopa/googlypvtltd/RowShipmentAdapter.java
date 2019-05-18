package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RowShipmentAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public RowShipmentAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RowShipment object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_shipment,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.oid = (TextView) row.findViewById(R.id.tx_1);
            contactHolder.wid = (TextView) row.findViewById(R.id.tx_2);
            contactHolder.sdate = (TextView) row.findViewById(R.id.tx_3);
            row.setTag(contactHolder);

        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        RowShipment cnt=(RowShipment) this.getItem(position);
        contactHolder.oid.setText(cnt.getOid());
        contactHolder.wid.setText(cnt.getWid());
        contactHolder.sdate.setText(cnt.getSdate());
        return row;
    }

    static class ContactHolder{
        TextView oid,wid,sdate;
    }
}
