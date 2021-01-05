package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Market3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market3);
     //정원이꺼 map뷰
    ViewPager mapVp = findViewById(R.id.mapview);
    VPAdapter mapAdapter = new VPAdapter(getSupportFragmentManager());
        mapAdapter.items.add(new MapsFragment());
        mapVp.setAdapter(mapAdapter);

    //시우꺼 슬라이드뷰
    ViewPager vp = findViewById(R.id.viewpager);
    VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.items.add(new FragmentMarket3Menu1());
        adapter.items.add(new FragmentMarket3Menu2());
        adapter.items.add(new FragmentMarket3Menu3());
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