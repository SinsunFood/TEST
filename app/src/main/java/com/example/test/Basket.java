package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class Basket extends AppCompatActivity {

    ScrollView mScrollview;
    private ListView m_oListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // 일단 데이터 생성 , 여기 데이터를 가게마다 따로 받아야 함 힘듦
        //가게의 메뉴를 입력받는 데이터
        String[] strDate = {"제육볶음", "묵은지", "콩자반", "파래무침", "감자조림", "파김치"};
        int nDatCnt=0;
        ArrayList<ItemDataBastket> oData = new ArrayList<>();
        for (int i=0; i<10; ++i)
        {
            ItemDataBastket oItem = new ItemDataBastket();
            oItem.strDate = strDate[nDatCnt++];
            oItem.strCount = (i+1) + "개";
            oItem.strCost = ((i+1)*1000) + "원";
            oData.add(oItem);
            if (nDatCnt >= strDate.length) nDatCnt = 0; //로테이션 돌리려고 하는 if문
        }

// ListViewBasket, ListAdapter 생성 및 연결
        m_oListView = (ListView)findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
        mScrollview = findViewById(R.id.scrollView);
    }


    public void toHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void toBasket(View view){
        // 맨위로 이동
        mScrollview.fullScroll(ScrollView.FOCUS_UP);
    }
}