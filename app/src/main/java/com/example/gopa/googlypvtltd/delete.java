package com.example.gopa.googlypvtltd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class delete extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getActivity().getTitle()=="Customer"){
            view=inflater.inflate(R.layout.update_customer, container, false);
            return view;
        } else if(getActivity().getTitle()=="Order Details"){
            view=inflater.inflate(R.layout.update_order_details, container, false);
            return view;
        } else if(getActivity().getTitle()=="Order Item"){
            view=inflater.inflate(R.layout.update_order_item, container, false);
            return view;
        } else if(getActivity().getTitle()=="Items"){
            view= inflater.inflate(R.layout.update_items, container, false);
            return view;
        } else if(getActivity().getTitle()=="Shipment"){
            view=inflater.inflate(R.layout.update_shipment, container, false);
            return view;
        } else if(getActivity().getTitle()=="Warehouse"){
            view=inflater.inflate(R.layout.update_warehouse, container, false);
            return view;
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
