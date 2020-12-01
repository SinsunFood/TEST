package com.example.test;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Market3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market3);
    }

    public void toHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}