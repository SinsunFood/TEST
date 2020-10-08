package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ViewPager viewPager;


    Button btn1,btn2,btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new Adapter(this);
        viewPager.setAdapter(adapter);





    }
    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), Fragment1.class);
        startActivity(intent);
    }
}