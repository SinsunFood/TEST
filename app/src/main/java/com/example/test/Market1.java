package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Market1 extends AppCompatActivity implements FragmentMenu1.OnMyListener {


    // 가게1의 메뉴정보를 담음
    final ArrayList<Menu> menuArrayList = new ArrayList<>();
    private static final String TAG = "MAIN";
    private TextView tv;
    Button orderButton;
    private RequestQueue queue;
    Menu menu;

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

/*        Menu menu = new Menu("100","100",100,100,"100");
        Intent intent = new Intent(this,Market2.class);

        intent.putExtra("person", menu);

        startActivity(intent);*/



        /////////////////////////////////////////////////////////////////////////////////
        // volley post - 주문정보 보내기
        orderButton = findViewById(R.id.order_button);
        String postUrl = "http://whthakd.dothome.co.kr/OrderInfo.php";
        final StringRequest postStringRequest = new StringRequest(Request.Method.POST, postUrl , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("menuName", menuArrayList.get(0).getMenuName());
                params.put("price", String.valueOf(menuArrayList.get(0).getPrice()));

                return params;
            }
        };
        postStringRequest.setTag(TAG);

        // order 버튼 클릭 시 주문 내역 php로 전송
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add(postStringRequest);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }
    /////////////////////////////////////////////////////////////////

    FragmentManager fm = getSupportFragmentManager();
    FragmentMenu1 fragment = (FragmentMenu1) fm.findFragmentById(R.id.viewpager);

    /*        ZoomImage zoomImage = new ZoomImage();
            zoomImage.*/

    //    public RecyclerView toFragment(){
//        RecyclerView rv = findViewById(R.id.recycler_view);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager( this,3);
//        rv.setLayoutManager(gridLayoutManager);
//        return rv;
//    }
    public void toHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onReceivedData(Object data,int mclickCount) {
        SharedPreferences pref= getSharedPreferences("pref", 0); // SharedPreferences 사용 선언
        SharedPreferences.Editor editor = pref.edit(); // deitor선언
        menu= (Menu)data;
        mclickCount++;
        String count = Integer.toString(mclickCount);
        editor.putString("id"+count,menu.getId());
        editor.putString("menuname"+count,menu.getMenuName());
        editor.putInt("price"+count,menu.getPrice());
        editor.putString("count"+count,count);
        editor.commit();

    }
}