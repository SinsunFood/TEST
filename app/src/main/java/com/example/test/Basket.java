package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Basket extends AppCompatActivity implements View.OnClickListener{

    ScrollView mScrollview;
    private ListView m_oListView = null;

    // 일단 데이터 생성 , 여기 데이터를 가게마다 따로 받아야 함 힘듦
    //가게의 메뉴를 입력받는 데이터
    String[] strDate = {"제육볶음", "묵은지", "콩자반", "파래무침", "감자조림", "파김치"};
    int nDatCnt = 0;
    ArrayList<ItemDataBastket> oData = new ArrayList<>(); // CustomList의 목록
    int arrayCnt = 0;
    int totalCost = 0;

    TextView text;

    public void sumCost(){
        totalCost = 0; // 호출 할 때마다 0으로 리셋
        text = (TextView)findViewById(R.id.totalCost);
        for(int i = 0; i < arrayCnt; i++)
        {
            totalCost += oData.get(i).getIntCost();
        }
        String sCost = "가격 : " + Integer.toString(totalCost) + "원";
        text.setText(sCost);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // 장바구니 리스트 한 번 출력 , 임시로 사용중임
        for (arrayCnt=0; arrayCnt<6; ++arrayCnt)
        {
            ItemDataBastket oItem = new ItemDataBastket();
            oItem.strMenu = strDate[nDatCnt++];
            oItem.intCount = (arrayCnt+1);
            oItem.strToIntCount(oItem.intCount);
            oItem.intCost = oItem.intCount * 1000;
            oItem.strToIntCost(oItem.intCost);
            oItem.onClickListener1 = this;
            oItem.onClickListener2 = this;
            oItem.onClickListener3 = this;
            oData.add(oItem);
            if (nDatCnt >= strDate.length) nDatCnt = 0; //로테이션 돌리려고 하는 if문
        }

        sumCost();

// ListViewBasket, ListAdapter 생성 및 연결
        m_oListView = (ListView)findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
        mScrollview = findViewById(R.id.scrollView);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.deleteButton) {
            View oParentView = (View) view.getParent(); // 부모의 View 가져온다. 즉, 아이템 View
            String position = (String) oParentView.getTag();
            int index = Integer.parseInt(position);

            oData.remove(index);
            arrayCnt--;
            sumCost();

            m_oListView = (ListView) findViewById(R.id.listView);
            ListAdapter oAdapter = new ListAdapter(oData);
            m_oListView.setAdapter(oAdapter);
            mScrollview = findViewById(R.id.scrollView);
        } else if(view.getId() == R.id.upButton){
            View oParentView = (View)view.getParent(); // 부모의 View 가져온다. 즉, 아이템 View
            String position = (String) oParentView.getTag();
            int index = Integer.parseInt(position);

            int iCount = oData.get(index).getIntCount(); // 수량변경
            iCount++;
            oData.get(index).setIntCount(iCount);
            oData.get(index).strToIntCount(iCount);

            int iCost = oData.get(index).getIntCost(); // 가격변경
            iCost++;
            oData.get(index).setIntCost(iCost);
            oData.get(index).strToIntCost(iCost);
            sumCost();

            m_oListView = (ListView)findViewById(R.id.listView);
            ListAdapter oAdapter = new ListAdapter(oData);
            m_oListView.setAdapter(oAdapter);
            mScrollview = findViewById(R.id.scrollView);
        } else if(view.getId() == R.id.downButton) {
            View oParentView = (View) view.getParent(); // 부모의 View 가져온다. 즉, 아이템 View
            String position = (String) oParentView.getTag();
            int index = Integer.parseInt(position);

            if(oData.get(index).getIntCount() == 1){
                oData.remove(index);
                arrayCnt--;
                sumCost();

                m_oListView = (ListView) findViewById(R.id.listView);
                ListAdapter oAdapter = new ListAdapter(oData);
                m_oListView.setAdapter(oAdapter);
                mScrollview = findViewById(R.id.scrollView);
            }else {
                int iCount = oData.get(index).getIntCount(); // 수량변경
                iCount--;
                oData.get(index).setIntCount(iCount);
                oData.get(index).strToIntCount(iCount);

                int iCost = oData.get(index).getIntCost(); // 가격변경
                iCost--;
                oData.get(index).setIntCost(iCost);
                oData.get(index).strToIntCost(iCost);
                sumCost();

                m_oListView = (ListView) findViewById(R.id.listView);
                ListAdapter oAdapter = new ListAdapter(oData);
                m_oListView.setAdapter(oAdapter);
                mScrollview = findViewById(R.id.scrollView);
            }
        }
    }


    public void toHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void toBasket(View view){
        mScrollview.fullScroll(ScrollView.FOCUS_UP);
    }
}
