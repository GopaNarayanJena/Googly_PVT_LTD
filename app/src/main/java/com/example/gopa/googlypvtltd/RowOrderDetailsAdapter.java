package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RowOrderDetailsAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public RowOrderDetailsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RowOrderDetails object) {
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
            row=layoutInflater.inflate(R.layout.row_orderdetails_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.id = (TextView) row.findViewById(R.id.tx_1);
            contactHolder.date = (TextView) row.findViewById(R.id.tx_2);
            contactHolder.cid = (TextView) row.findViewById(R.id.tx_3);
            contactHolder.oamt = (TextView) row.findViewById(R.id.tx_4);
            row.setTag(contactHolder);

        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        RowOrderDetails cnt=(RowOrderDetails) this.getItem(position);
        contactHolder.id.setText(cnt.getOid());
        contactHolder.date.setText(cnt.getDate());
        contactHolder.cid.setText(cnt.getCid());
        contactHolder.oamt.setText(cnt.getOamt());
        return row;
    }

    static class ContactHolder{
        TextView id,date,cid,oamt;
    }
}
