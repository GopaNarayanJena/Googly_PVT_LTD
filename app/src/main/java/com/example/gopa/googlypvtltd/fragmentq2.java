package com.example.gopa.googlypvtltd;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmentq2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View row;
        row=inflater.inflate(R.layout.fragmentq2,container,false);
        return row;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Query2");
        String tablename = (String) getActivity().getTitle();
        String type = "query";
        String q="select Cname as customer_name, count(ORDER_DETAILS.Cust) as no_of_orders,\n" +
                "avg(Ord_Amt) as avg_order_amt \n" +
                "from CUSTOMER,ORDER_DETAILS \n" +
                "where ORDER_DETAILS.Cust=CUSTOMER.Cust \n" +
                "group by ORDER_DETAILS.Cust;";
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Executed Query");
        builder.setMessage(q);
        AlertDialog alertDialog=builder.create();
        constants.progressDialog = new ProgressDialog(getContext());
        constants.progressDialog.setTitle("loading");
        constants.progressDialog.setMessage("please wait....");
        constants.progressDialog.show();
        constants.progressDialog.setCancelable(false);
        alertDialog.show();
        BackgroundWorker backgroundWorker = new BackgroundWorker(getContext(),view);
        backgroundWorker.execute(type, tablename);
    }


}
