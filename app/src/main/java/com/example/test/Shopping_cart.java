package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class Shopping_cart extends AppCompatActivity {

    ScrollView cScrollview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        cScrollview = findViewById(R.id.cart_scrollView);


    }

    public void cart_toHome(View view){ // 홈화면에서 장바구니로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void cart_toCart(View view){ // 홈화면에서 홈버튼 누르면 화면 맨위로 이동
        cScrollview.fullScroll(ScrollView.FOCUS_UP);
    }

}