package com.my.worldclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private TextView Sydneytime;
    private TextView Beijingtime;
    private TextView Londontime;
    private TextView Tokyotime;
    private TextView Paristime;
    private TextView NewYorktime;
    private TextView time12;
    private TextView time24;
    private String aa ="aa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aView();
        aEvent();

        handler.postDelayed(runnable, 2000);
    }

    private void aEvent() {
        time12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                aa ="aa";
                time12.setBackgroundColor(getResources().getColor(R.color.black));
                time12.setTextColor(getResources().getColor(R.color.white));
                time24.setBackgroundColor(getResources().getColor(R.color.white));
                time24.setTextColor(getResources().getColor(R.color.black));
                getWorldTime();
            }
        });

        time24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                aa ="bb";
                time24.setBackgroundColor(getResources().getColor(R.color.black));
                time24.setTextColor(getResources().getColor(R.color.white));
                time12.setBackgroundColor(getResources().getColor(R.color.white));
                time12.setTextColor(getResources().getColor(R.color.black));
                getWorldTime();
            }
        });

    }


    Handler handler=new Handler();

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            getWorldTime();
            handler.postDelayed(this, 2000);
        }
    };

    private void getWorldTime() {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat easytime = null;
        if (aa.equals("bb")){
            easytime = new SimpleDateFormat("HH:mm");
        }else {
            easytime = new SimpleDateFormat("hh:mm");

        }
        easytime.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        Sydneytime.setText(easytime.format(date.getTime()));

        easytime.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Beijingtime.setText(easytime.format(date.getTime()));

        easytime.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        NewYorktime.setText(easytime.format(date.getTime()));

        easytime.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        Tokyotime.setText(easytime.format(date.getTime()));

        easytime.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        Londontime.setText(easytime.format(date.getTime()));

        easytime.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        Paristime.setText(easytime.format(date.getTime()));
    }

    private void aView() {
        Sydneytime=findViewById(R.id.sydneytime);
        Beijingtime=findViewById(R.id.beijingtime);
        NewYorktime=findViewById(R.id.newyorktime);
        Tokyotime=findViewById(R.id.tokyotime);
        Londontime=findViewById(R.id.londontime);
        Paristime=findViewById(R.id.paristime);
        time12=findViewById(R.id.time_12);
        time24=findViewById(R.id.time_24);
    }
}
