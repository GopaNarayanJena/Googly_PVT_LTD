package com.example.gopa.googlypvtltd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    public static Intent intent1;
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.tv);
        iv=findViewById(R.id.iv);
        Thread timer=new Thread(){
            public void run(){
                Animation animation=AnimationUtils.loadAnimation(splash.this,R.anim.anim_splash);
                iv.startAnimation(animation);
                tv.startAnimation(animation);
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //startActivity(intent1);
                finish();
            }
        };
        timer.start();
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        constants.flag=true;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        intent1=new Intent(this,MainActivity.class);
        String tablename = "All";
        String type = "select";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, tablename);

    }
}
