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
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ViewPager viewPager;
    ScrollView mScrollview;

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new Adapter(this);
        viewPager.setAdapter(adapter);
        mScrollview = findViewById(R.id.scrollView);





    }

    public void toMarket1(View view){ // 반찬가게 1로 바꿈
        Intent intent = new Intent(getApplicationContext(), Market1.class);
        startActivity(intent);
    }

    public void toMarket2(View view){ // 반찬가게 2로
        Intent intent = new Intent(getApplicationContext(), Market2.class);
        startActivity(intent);
    }

    public void toMarket3(View view){ // 반찬가게 3으로
        Intent intent = new Intent(getApplicationContext(), Market3.class);
        startActivity(intent);
    }

    public void toHome(View view){
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intent);
        // 홈화면에서 홈버튼 누르면 화면 맨위로 이동
        mScrollview.fullScroll(ScrollView.FOCUS_UP);
    }


}