package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RowItemsAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public RowItemsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(RowItems object) {
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
            row=layoutInflater.inflate(R.layout.row_items_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tx_id = (TextView) row.findViewById(R.id.tx_1);
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tx_2);
            row.setTag(contactHolder);

        }
        else{
            contactHolder = (ContactHolder)row.getTag();
        }
        RowItems cnt=(RowItems) this.getItem(position);
        contactHolder.tx_id.setText(cnt.getId());
        contactHolder.tx_name.setText(cnt.getPrice());
        return row;
    }

    static class ContactHolder{
        TextView tx_id,tx_name;
    }
}
