package com.example.gopa.googlypvtltd;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class constants {
   // public static int id;
    public static boolean flag=false;
    private static final String root_url="https://modernism-exhibits.000webhostapp.com/";
    public static final String customer_insert_url=root_url+"customer_insert.php";
    public static final String customer_select_url=root_url+"customer_select.php";
    public static final String customer_delete_url=root_url+"customer_delete.php";
    public static final String item_insert_url=root_url+"item_insert.php";
    public static final String item_select_url=root_url+"item_select.php";
    public static final String item_delete_url=root_url+"item_delete.php";
    public static final String order_details_insert_url=root_url+"order_details_insert.php";
    public static final String order_details_select_url=root_url+"order_details_select.php";
    public static final String order_details_delete_url=root_url+"order_details_delete.php";
    public static final String order_items_insert_url=root_url+"order_items_insert.php";
    public static final String order_items_select_url=root_url+"order_items_select.php";
    public static final String order_items_delete_url=root_url+"order_items_delete.php";
    public static final String shipment_insert_url=root_url+"shipment_insert.php";
    public static final String shipment_select_url=root_url+"shipment_select.php";
    public static final String shipment_delete_url=root_url+"shipment_delete.php";
    public static final String warehouse_insert_url=root_url+"warehouse_insert.php";
    public static final String warehouse_select_url=root_url+"warehouse_select.php";
    public static final String warehouse_delete_url=root_url+"warehouse_delete.php";
    public static final String reference_url=root_url+"reference.php";
    public static final String query1_url=root_url+"query1.php";
    public static final String query2_url=root_url+"query2.php";
    public static ActionBar actionBar;
    public static String query2_city="";
    public static List<String> customerId;
    public static List<String> itemId;
    public static List<String> orderId;
    public static List<String> orderitem;
    public static List<String> shipid;
    public static List<String> warehouseId;
    public static MenuInflater menuInflater;

    public static String json_text;
    public  static ProgressDialog progressDialog;

    public void toshow(View row, Context context,String title){
         ListView listView;
         JSONObject jsonObject;
         JSONArray jsonArray;
         if(title.equals("All")){
             customerId=new ArrayList<>();
             itemId=new ArrayList<>();
             orderId=new ArrayList<>();
             warehouseId=new ArrayList<>();
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     if(jo.toString().contains("custid")) {
                         customerId.add(jo.getString("custid"));
                     }else if(jo.toString().contains("orderid")){
                         orderId.add(jo.getString("orderid"));
                     }else if(jo.toString().contains("itemid")) {
                         itemId.add(jo.getString("itemid"));
                     }else  if(jo.toString().contains("warehouseid")){
                         warehouseId.add(jo.getString("warehouseid"));
                     }
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Customer")){
            customerId=null;
            customerId=new ArrayList<>();
            listView=(ListView) row.findViewById(R.id.profile);
            RowCustomerAdapter contactAdapter;
            contactAdapter=new RowCustomerAdapter(context,R.layout.row_customer_layout);
            listView.setAdapter(contactAdapter);
            try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String id,name,city;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     id=jo.getString("id");
                     name=jo.getString("name");
                     city=jo.getString("city");
                     customerId.add(id);
                     RowCustomer contct=new RowCustomer(id,name,city);
                     contactAdapter.add(contct);
                     count++;
                 }
            } catch (JSONException e) {
                e.printStackTrace();
            }
         }else if(title.equals("Items")){
             itemId=null;
             itemId=new ArrayList<>();
             listView=(ListView) row.findViewById(R.id.profile);
             RowItemsAdapter rowItemsAdapter;
             rowItemsAdapter=new RowItemsAdapter(context,R.layout.row_items_layout);
             listView.setAdapter(rowItemsAdapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String id,name;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     id=jo.getString("id");
                     name=jo.getString("price");
                     itemId.add(id);
                     RowItems contct=new RowItems(id,name);
                     rowItemsAdapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Order Details")){
             orderId=null;
             orderId=new ArrayList<>();
             listView=(ListView) row.findViewById(R.id.profile);
             RowOrderDetailsAdapter rowOrderDetailsAdapter;
             rowOrderDetailsAdapter=new RowOrderDetailsAdapter(context,R.layout.row_orderdetails_layout);
             listView.setAdapter(rowOrderDetailsAdapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String id,date,cid,amt;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     id=jo.getString("id");
                     date=jo.getString("date");
                     cid=jo.getString("cid");
                     amt=jo.getString("amt");
                     orderId.add(id);
                     RowOrderDetails contct=new RowOrderDetails(id,date,cid,amt);
                     rowOrderDetailsAdapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         } else if(title.equals("Order Item")){
             orderitem=null;
             orderitem=new ArrayList<>();
             listView=(ListView) row.findViewById(R.id.profile);
             RowOrderItemAdapter rowOrderItemAdapter;
             rowOrderItemAdapter=new RowOrderItemAdapter(context,R.layout.row_orderitem_layout);
             listView.setAdapter(rowOrderItemAdapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String oid,iid,qty;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     oid=jo.getString("oid");
                     iid=jo.getString("iid");
                     qty=jo.getString("qty");
                     orderitem.add(oid+"_"+iid);
                     RowOrderItem contct=new RowOrderItem(oid,iid,qty);
                     rowOrderItemAdapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Shipment")){
             shipid=null;
             shipid=new ArrayList<>();
             listView=(ListView) row.findViewById(R.id.profile);
             RowShipmentAdapter rowShipmentAdapter;
             rowShipmentAdapter=new RowShipmentAdapter(context,R.layout.row_shipment);
             listView.setAdapter(rowShipmentAdapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String oid,wid,sdate;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     oid=jo.getString("oid");
                     wid=jo.getString("wid");
                     sdate=jo.getString("sdate");
                     shipid.add(oid+"_"+wid);
                     RowShipment contct=new RowShipment(oid,wid,sdate);
                     rowShipmentAdapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Warehouse")){
             warehouseId=null;
             warehouseId=new ArrayList<>();
             listView=(ListView) row.findViewById(R.id.profile);
             RowwarehouseAdapter rowwarehouseAdapter;
             rowwarehouseAdapter=new RowwarehouseAdapter(context,R.layout.row_warehouse_layout);
             listView.setAdapter(rowwarehouseAdapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String id,city;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     id=jo.getString("id");
                     city=jo.getString("city");
                     warehouseId.add(id);
                     RowWarehouse contct=new RowWarehouse(id,city);
                     rowwarehouseAdapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Query1")){
             listView=(ListView) row.findViewById(R.id.profile);
             RowQuery1Adapter rowQuery1Adapter;
             rowQuery1Adapter=new RowQuery1Adapter(context,R.layout.row_query1_layout);
             listView.setAdapter(rowQuery1Adapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String cname,noo,avg;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     cname=jo.getString("cname");
                     noo=jo.getString("noo");
                     avg=jo.getString("avg");
                     RowQuery1 contct=new RowQuery1(cname,noo,avg);
                     rowQuery1Adapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }else if(title.equals("Query2")){
             listView=(ListView) row.findViewById(R.id.profile);
             RowQuery2Adapter rowQuery2Adapter;
             rowQuery2Adapter=new RowQuery2Adapter(context,R.layout.row_query2_layout);
             listView.setAdapter(rowQuery2Adapter);
             try {
                 jsonObject=new JSONObject(constants.json_text);
                 jsonArray=jsonObject.getJSONArray("response");
                 int count=0;
                 String oid,sdate;
                 while (count<jsonArray.length()){
                     JSONObject jo=jsonArray.getJSONObject(count);
                     oid=jo.getString("oid");
                     sdate=jo.getString("sdate");
                     RowQuery2 contct=new RowQuery2(oid,sdate);
                     rowQuery2Adapter.add(contct);
                     count++;
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }

    }
}
