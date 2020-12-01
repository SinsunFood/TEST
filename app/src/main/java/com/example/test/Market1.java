package com.example.test;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Market1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market1);

        ViewPager vp = findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
    }

    public void toHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}