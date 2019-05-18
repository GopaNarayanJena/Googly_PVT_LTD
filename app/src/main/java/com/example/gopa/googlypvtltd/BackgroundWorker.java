package com.example.gopa.googlypvtltd;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String,Void,String> {
    String json_string;
    Context context;
    View view;
    String type;
    String tablename;
    String s1="";
    String s2="";

    BackgroundWorker(Context ctx){
        context=ctx;
    }
    BackgroundWorker(Context ctx,View v){
        context=ctx;
        view=v;
    }

    public String conn(String login_url,String post_data){
        try {
            URL url= new URL(login_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            StringBuilder stringBuilder=new StringBuilder();
            while ((json_string=bufferedReader.readLine())!=null){
                stringBuilder.append(json_string+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String doInBackground(String... params) {
        type=params[0];
        tablename=params[1];
        String login_url="";
        String result="";
        String post_data="";
        if(type.equals("select")){

            if(tablename.equals("Customer")){
                login_url=constants.customer_select_url;
            }else if(tablename.equals("Items")){
                login_url=constants.item_select_url;
            }else if(tablename.equals("Order Details")) {
                login_url = constants.order_details_select_url;
            }else if(tablename.equals("Order Item")){
                login_url=constants.order_items_select_url;
            }else if(tablename.equals("Shipment")){
                login_url=constants.shipment_select_url;
            }else if(tablename.equals("Warehouse")){
                login_url=constants.warehouse_select_url;
            }else if(tablename.equals("All")){
                login_url=constants.reference_url;
            }
            try {
                post_data=URLEncoder.encode("tablename","UTF-8")+"="+URLEncoder.encode(tablename,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            result=conn(login_url,post_data);
            return result;

        }else if(type.equals("insert")){

            if(tablename.equals("Customer")){
                login_url=constants.customer_insert_url;
                String custid=params[2];
                String custname=params[3];
                String custcity=params[4];
                try {
                    post_data=URLEncoder.encode("custid","UTF-8")+"="+URLEncoder.encode(custid,"UTF-8")+"&"+
                            URLEncoder.encode("custname","UTF-8")+"="+URLEncoder.encode(custname,"UTF-8")+"&"+
                            URLEncoder.encode("custcity","UTF-8")+"="+URLEncoder.encode(custcity,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Items")){
                login_url=constants.item_insert_url;
                String itemid=params[2];
                String price=params[3];
                try {
                    post_data=URLEncoder.encode("itemid","UTF-8")+"="+URLEncoder.encode(itemid,"UTF-8")+"&"+
                            URLEncoder.encode("price","UTF-8")+"="+URLEncoder.encode(price,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Order Details")) {
                login_url = constants.order_details_insert_url;
                String orderid=params[2];
                String orderdate=params[3];
                String ordercustid=params[4];
                String orderamt=params[5];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8")+"&"+
                            URLEncoder.encode("orderdate","UTF-8")+"="+URLEncoder.encode(orderdate,"UTF-8")+"&"+
                            URLEncoder.encode("ordercustid","UTF-8")+"="+URLEncoder.encode(ordercustid,"UTF-8")+"&"+
                            URLEncoder.encode("orderamt","UTF-8")+"="+URLEncoder.encode(orderamt,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Order Item")){
                login_url=constants.order_items_insert_url;
                String orderid=params[2];
                String item=params[3];
                String orderqty=params[4];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8")+"&"+
                            URLEncoder.encode("item","UTF-8")+"="+URLEncoder.encode(item,"UTF-8")+"&"+
                            URLEncoder.encode("orderqty","UTF-8")+"="+URLEncoder.encode(orderqty,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Shipment")){
                login_url=constants.shipment_insert_url;
                String orderid=params[2];
                String warehouseid=params[3];
                String shipdate=params[4];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8")+"&"+
                            URLEncoder.encode("warehouseid","UTF-8")+"="+URLEncoder.encode(warehouseid,"UTF-8")+"&"+
                            URLEncoder.encode("shipdate","UTF-8")+"="+URLEncoder.encode(shipdate,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Warehouse")){
                login_url=constants.warehouse_insert_url;
                String warehouseid=params[2];
                String city=params[3];
                try {
                    post_data=URLEncoder.encode("warehouseid","UTF-8")+"="+URLEncoder.encode(warehouseid,"UTF-8")+"&"+
                            URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(city,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            result=conn(login_url,post_data);
            return result;
        }else if(type.equals("delete")){
            if(tablename.equals("Customer")){
                login_url=constants.customer_delete_url;
                String custid=params[2];
                s1=params[2];
                try {
                    post_data=URLEncoder.encode("custid","UTF-8")+"="+URLEncoder.encode(custid,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Items")){
                login_url=constants.item_delete_url;
                String item=params[2];
                s1=params[2];
                try {
                    post_data=URLEncoder.encode("item","UTF-8")+"="+URLEncoder.encode(item,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Order Details")){
                login_url=constants.order_details_delete_url;
                String orderid=params[2];
                s1=params[2];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Order Item")){
                login_url=constants.order_items_delete_url;
                String orderid=params[2];
                s1=params[2];
                String item=params[3];
                s2=params[3];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8")+"&"+
                            URLEncoder.encode("item","UTF-8")+"="+URLEncoder.encode(item,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Shipment")){
                login_url=constants.shipment_delete_url;
                String orderid=params[2];
                s1=params[2];
                String warehouse=params[3];
                s2=params[3];
                try {
                    post_data=URLEncoder.encode("orderid","UTF-8")+"="+URLEncoder.encode(orderid,"UTF-8")+"&"+
                            URLEncoder.encode("warehouse","UTF-8")+"="+URLEncoder.encode(warehouse,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Warehouse")){
                login_url=constants.warehouse_delete_url;
                String warehouse=params[2];
                s1=params[2];
                try {
                    post_data=URLEncoder.encode("warehouse","UTF-8")+"="+URLEncoder.encode(warehouse,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            result=conn(login_url,post_data);
            return result;
        }else if(type.equals("query")){
            if(tablename.equals("Query1")){
                login_url=constants.query1_url;
                try {
                    post_data=URLEncoder.encode("tablename","UTF-8")+"="+URLEncoder.encode(tablename,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(tablename.equals("Query2")){
                login_url=constants.query2_url;
                String city=constants.query2_city;
                try {
                    post_data=URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(city,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            result=conn(login_url,post_data);
            return result;
        }
        return null;
    }

    /*@Override
    protected void onPreExecute() {
    }*/

    @Override
    protected void onPostExecute(String result) {
        constants.json_text=result;
        if(!tablename.equals("All")){
            constants.progressDialog.setCancelable(true);
            constants.progressDialog.dismiss();
        }
        if(type.equals("select")){
            if(result.contains("message")){
                    Toast.makeText(context,"Data Fetch Unsuccessful",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context,"Data Fetch Successful",Toast.LENGTH_SHORT).show();
                constants cnt=new constants();
                cnt.toshow(view,context,tablename);
                constants.json_text=null;
                if(tablename.equals("All")){
                    context.startActivity(splash.intent1);
                }
            }
        }else if(type.equals("insert")){
            if(result.contains("false")){
                Toast.makeText(context,"Uploaded Successfully",Toast.LENGTH_SHORT).show();
            }else{
                try {
                    JSONObject jsonobj = new JSONObject(result);
                    String msg =jsonobj.getString("message");
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Insertion Error");
                    builder.setMessage(msg);
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else if(type.equals("delete")){
            if(result.contains("false")){
                Toast.makeText(context,"Deleted Successful",Toast.LENGTH_SHORT).show();
            }else{
                //Toast.makeText(context,"delete unsuccessfully",Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonobj = new JSONObject(result);
                    String msg =jsonobj.getString("message");
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Deletion Error for "+s1+" "+s2);
                    builder.setMessage(msg);
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else if(type.equals("query")){
            if(result.contains("message")){
                Toast.makeText(context,"Data Fetch Unsuccessful",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context,"Data Fetch successful",Toast.LENGTH_SHORT).show();
                constants cnt=new constants();
                cnt.toshow(view,context,tablename);
                constants.json_text=null;
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
