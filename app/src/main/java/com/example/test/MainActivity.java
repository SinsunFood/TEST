package com.example.test;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


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

    public void toHome(View view){ // 홈화면에서 홈버튼 누르면 화면 맨위로 이동
        mScrollview.fullScroll(ScrollView.FOCUS_UP);
    }

    public void toAlr(View view){ //toAlram이라 할랬으나 Alarm이 이미 있는 변수나 함수인거같음
        Intent intent = new Intent(getApplicationContext(), AlramPage.class);
        startActivity(intent);
    }


    public void toCart(View view){ // 홈화면에서 장바구니로 이동
        Intent intent = new Intent(this, Shopping_cart.class);
        startActivity(intent);
    }

}