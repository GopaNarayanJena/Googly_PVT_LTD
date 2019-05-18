package com.example.gopa.googlypvtltd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class update extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getActivity().getTitle()=="Customer"){
            return inflater.inflate(R.layout.update_customer, container, false);
        } else if(getActivity().getTitle()=="Order Details"){
            return inflater.inflate(R.layout.update_order_details, container, false);
        } else if(getActivity().getTitle()=="Order Item"){
            return inflater.inflate(R.layout.update_order_item, container, false);
        } else if(getActivity().getTitle()=="Items"){
            return inflater.inflate(R.layout.update_items, container, false);
        } else if(getActivity().getTitle()=="Shipment"){
            return inflater.inflate(R.layout.update_shipment, container, false);
        } else if(getActivity().getTitle()=="Warehouse"){
            return inflater.inflate(R.layout.update_warehouse, container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity().getTitle()=="Customer"){
        } else if(getActivity().getTitle()=="Order Details"){
            Spinner spinner=view.findViewById(R.id.order_ocid);
            ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,constants.customerId);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter1);
        } else if(getActivity().getTitle()=="Order Item"){
            Spinner txt1=(Spinner) view.findViewById(R.id.oi_oid);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,constants.orderId);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txt1.setAdapter(adapter);
            Spinner txt2=(Spinner) view.findViewById(R.id.oi_iid);
            ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,constants.itemId);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txt2.setAdapter(adapter1);
        } else if(getActivity().getTitle()=="Items"){
        } else if(getActivity().getTitle()=="Shipment"){
            Spinner txt1=(Spinner) view.findViewById(R.id.shipment_oid);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,constants.orderId);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txt1.setAdapter(adapter);
            Spinner txt2=(Spinner) view.findViewById(R.id.shipment_wid);
            ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,constants.warehouseId);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txt2.setAdapter(adapter1);
        } else if(getActivity().getTitle()=="Warehouse"){
        }
    }


}
