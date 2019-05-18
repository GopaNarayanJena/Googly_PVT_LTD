package com.example.gopa.googlypvtltd;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(constants.flag==false){
            Intent intent=new Intent(this,splash.class);
            startActivity(intent);
            this.finish();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        constants.actionBar=getSupportActionBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //uncomment to have floating widget
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                displaySelectScreen(R.id.fab);
            }
        });
        this.setTitle("Home");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.customer);
        displaySelectScreen(R.id.customer);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override //uncomment to add setting option in menubar
    public boolean onCreateOptionsMenu(Menu menu) {
        constants.menuInflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        displaySelectScreen(id);

        return super.onOptionsItemSelected(item);
    }

    public void displaySelectScreen(int id){
        Fragment fragment=null;

        if (id == R.id.customer) {
            fragment=new tcustomer();
        } else if (id == R.id.order_details) {
            fragment=new torder_details();
        } else if (id == R.id.order_item) {
            fragment=new torder_item();
        } else if (id == R.id.items) {
            fragment=new titems();
        } else if (id == R.id.shipment) {
            fragment=new tshipment();
        } else if (id == R.id.warehouse) {
            fragment =new twarehouse();
        } else if (id == R.id.q1) {
            fragment = new query1();
        } else if (id == R.id.q2) {
            fragment =new query2();
        } else if (id == R.id.q3) {

        } else if (id == R.id.fab) {
            fragment = new update();
        } /*else if (id == R.id.delete){
            fragment=new delete();
        } else if (id == R.id.search){
            fragment=new search();
        }*/

        if(fragment!=null){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelectScreen(id);
        return true;
    }

    BackgroundWorker backgroundWorker;

    public void common(){
        constants.progressDialog = new ProgressDialog(this);
        constants.progressDialog.setTitle("loading");
        constants.progressDialog.setMessage("please wait....");
        constants.progressDialog.show();
        constants.progressDialog.setCancelable(false);
        backgroundWorker=new BackgroundWorker(this);
    }
    public void dialogbox(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Empty Input is not Valid");
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    public void Onsubmitcustomer(View v){
        EditText txt1=(EditText) findViewById(R.id.cust_cid);
        EditText txt2=(EditText) findViewById(R.id.cust_cname);
        EditText txt3=(EditText) findViewById(R.id.cust_city);
        String s1,s2,s3;
        s1=txt1.getText().toString();
        s2=txt2.getText().toString();
        s3=txt3.getText().toString();
        if(s2.equals("")||s3.equals("")){
           dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Customer",s1,s2,s3);}
    }

    public void Onsubmititems(View v){
        EditText txt1=(EditText) findViewById(R.id.items_oid);
        EditText txt2=(EditText) findViewById(R.id.items_price);
        String s1,s2;
        s1=txt1.getText().toString();
        s2=txt2.getText().toString();
        if(s2.equals("")){
            dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Items",s1,s2);}
    }

    public void OnsubmitOrderDetails(View v){
        EditText txt1=(EditText) findViewById(R.id.order_oid);
        EditText txt2=(EditText) findViewById(R.id.order_odate);
        Spinner txt3=(Spinner) findViewById(R.id.order_ocid);
        EditText txt4=(EditText) findViewById(R.id.order_oamt);
       /* ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,constants.customerId);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txt3.setAdapter(adapter1);*/
        String s1,s2,s3,s4;
        s1=txt1.getText().toString();
        s2=txt2.getText().toString();
        s3=txt3.getSelectedItem().toString();
        s4=txt4.getText().toString();
        if(s2.equals("")||s3.equals("")||s4.equals("")){
            dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Order Details",s1,s2,s3,s4);}
    }

    public void OnsubmitOrderitem(View v){
        Spinner txt1=(Spinner) findViewById(R.id.oi_oid);
        Spinner txt2=(Spinner) findViewById(R.id.oi_iid);
        EditText txt3=(EditText) findViewById(R.id.oi_qty);
        String s1,s2,s3;
        s1=txt1.getSelectedItem().toString();
        s2=txt2.getSelectedItem().toString();
        s3=txt3.getText().toString();
        if(s3.equals("")){
            dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Order Item",s1,s2,s3);}
    }

    public void Onsubmitshipment(View v){
        Spinner txt1=(Spinner) findViewById(R.id.shipment_oid);
        Spinner txt2=(Spinner) findViewById(R.id.shipment_wid);
        EditText txt3=(EditText) findViewById(R.id.shipment_sdate);
        String s1,s2,s3;
        s1=txt1.getSelectedItem().toString();
        s2=txt2.getSelectedItem().toString();
        s3=txt3.getText().toString();
        if(s3.equals("")){
            dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Shipment",s1,s2,s3);}
    }

    public void Onsubmitwarehouse(View v){
        EditText txt1=(EditText) findViewById(R.id.warehouse_wid);
        EditText txt2=(EditText) findViewById(R.id.warehouse_city);
        String s1,s2;
        s1=txt1.getText().toString();
        s2=txt2.getText().toString();
        if(s1.equals("")||s2.equals("")){
            dialogbox();
        }else{
        common();
        backgroundWorker.execute("insert","Warehouse",s1,s2);}
    }

    public void citysubmit(View v){
        EditText txt1=(EditText) findViewById(R.id.wid);
        String s1=txt1.getText().toString();
        if(s1.equals("")){
            dialogbox();
        }else {
            constants.query2_city = s1;
            Fragment f = new fragmentq2();
            if(f!=null){
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main,f);
                ft.commit();
            }
        }
    }

}
