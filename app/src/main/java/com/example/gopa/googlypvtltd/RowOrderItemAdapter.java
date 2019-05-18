package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RowOrderItemAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public RowOrderItemAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RowOrderItem object) {
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
            row=layoutInflater.inflate(R.layout.row_orderitem_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.oid = (TextView) row.findViewById(R.id.tx_1);
            contactHolder.iid = (TextView) row.findViewById(R.id.tx_2);
            contactHolder.qty = (TextView) row.findViewById(R.id.tx_3);
            row.setTag(contactHolder);

        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        RowOrderItem cnt=(RowOrderItem) this.getItem(position);
        contactHolder.oid.setText(cnt.getOid());
        contactHolder.iid.setText(cnt.getIid());
        contactHolder.qty.setText(cnt.getQty());
        return row;
    }

    static class ContactHolder{
        TextView oid,iid,qty;
    }
}
