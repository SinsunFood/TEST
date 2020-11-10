package com.example.test;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class Market1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market1);

        //정원이꺼 map뷰
        ViewPager mapVp = findViewById(R.id.mapview);
        VPAdapter mapAdapter = new VPAdapter(getSupportFragmentManager());
        mapAdapter.items.add(new MapsFragment());
        mapVp.setAdapter(mapAdapter);

        //시우꺼 슬라이드뷰
        ViewPager vp = findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.items.add(new FragmentMenu1());
        adapter.items.add(new FragmentMenu2());
        adapter.items.add(new FragmentMenu3());
        adapter.itext.add("메뉴");
        adapter.itext.add("리뷰");
        adapter.itext.add("매장정보");


        vp.setAdapter(adapter); // adapter 전에 넣어놓기

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);



    }

    public void toHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}