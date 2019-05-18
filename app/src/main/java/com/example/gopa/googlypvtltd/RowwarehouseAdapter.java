package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RowwarehouseAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public RowwarehouseAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RowWarehouse object) {
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
            row=layoutInflater.inflate(R.layout.row_warehouse_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.id = (TextView) row.findViewById(R.id.tx_1);
            contactHolder.city = (TextView) row.findViewById(R.id.tx_2);
            row.setTag(contactHolder);

        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        RowWarehouse cnt=(RowWarehouse) this.getItem(position);
        contactHolder.id.setText(cnt.getId());
        contactHolder.city.setText(cnt.getCity());
        return row;
    }

    static class ContactHolder{
        TextView id,city;
    }
}
