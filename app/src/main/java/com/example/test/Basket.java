package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.model.VisibleRegion;

import java.util.ArrayList;

public class Basket extends AppCompatActivity implements View.OnClickListener{

    ScrollView mScrollview;
    private ListView m_oListView = null;

    // 일단 데이터 생성 , 여기 데이터를 가게마다 따로 받아야 함 힘듦
    //가게의 메뉴를 입력받는 데이터
    String[] strDate = {"제육볶음", "묵은지", "콩자반", "파래무침", "감자조림", "파김치"};
    int nDatCnt=0;
    int datCnt=5; // 일단 strData에 들어간 값의 수를 나타내기 위해서 사용 서버에서 받아오면 가변적으로 받아야함
    ArrayList<ItemDataBastket> oData = new ArrayList<>();

    // 장바구니 리스트 출력하는 함수 나중에 서버에서 가져와서 출력하는걸로 바꿔야함
    private void print(){
        for (int i=0; i<datCnt; ++i)
        {
            ItemDataBastket oItem = new ItemDataBastket();
            oItem.strDate = strDate[nDatCnt++];
            oItem.strCount = (i+1) + "개";
            oItem.strCost = ((i+1)*1000) + "원";
            oItem.onClickListener = this; // 버튼 이벤트 받기 위해서 추가
            oData.add(oItem);
            if (nDatCnt >= strDate.length) nDatCnt = 0; //로테이션 돌리려고 하는 if문
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // 장바구니 리스트 한 번 출력;
        print();


// ListViewBasket, ListAdapter 생성 및 연결
        m_oListView = (ListView)findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
        mScrollview = findViewById(R.id.scrollView);

    }

    private void removePrint(View view){
        m_oListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                oData.remove(position);
            }
        });

     /*   oData.remove(0); // 임의로 인덱스 0의 값을 삭제 후 다시 출력
        datCnt--; // 이걸 하나씩 낮춰줘야 하는지 확실히 모름 없어도 화면출력에 문제는 없지만 나중에 필요할듯함
    */
    }

    // 삭제 버튼 누를시
    @Override
    public void onClick(View view) {
        ListAdapter oAdapter = new ListAdapter(oData);

        removePrint(view);
        oAdapter.notifyDataSetChanged();

        m_oListView = (ListView)findViewById(R.id.listView);
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