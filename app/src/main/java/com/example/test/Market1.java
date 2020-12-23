package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;


public class Market1 extends AppCompatActivity {


    final ArrayList<Store1_menu> store1MenuArrayList = new ArrayList<Store1_menu>();
    // 가게1의 메뉴정보를 담음
    private static final String TAG = "MAIN";
    private TextView tv;
    private RequestQueue queue;


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


        // 철순꺼 메뉴정보불러오기
        final Gson gson = new Gson();

        tv = findViewById(R.id.tvMain); // 디버깅용
        queue = Volley.newRequestQueue(this);
        String url ="http://whthakd.dothome.co.kr/get_Store1MenuData.php";

        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = (JsonObject) jsonParser.parse(response); //json 전체 파싱

                    JsonArray jsonArray = jsonObject.getAsJsonArray("STORE1_MENU");

                    for(int i=0;i<jsonArray.size();i++){
                        JsonElement jsonElement = jsonArray.get(i);
                        Store1_menu store1_menu = gson.fromJson(jsonElement.toString(), Store1_menu.class);
                        store1MenuArrayList.add(i, store1_menu);
                    }
                    tv.setText(store1MenuArrayList.get(0)  + "\n");

                } catch (Exception e) {
                    e.printStackTrace();
                    tv.setText("error"  + "\n");

                }




                // jsonArray로 저장한 데이터 list로 구현하기
                /*
                JsonElement jsonElement1 = jsonArray.get(0);  //-> Apple
                JsonElement jsonElement2 = jsonArray.get(1);  //-> Lemon

                String Name1 = jsonElement1.getAsJsonObject().get("menuName").getAsString();
                String Name2 = jsonElement2.getAsJsonObject().get("menuName").getAsString();


                 */





                //tv.setText(jsonObject + "\n");



                /*
                try {
                    /*
                    int index = 0;
                    while (index < jsonArray.le) {
                        Store1_menu store1_menu = gson.fromJson(jsonArray.get(index).toString(), Store1_menu.class);
                        store1_menuArrayList.add(store1_menu);

                        index++;
                    }

                     */
                   /*
                    String json = String.valueOf(jsonElement);

                    JSONObject jsonObject = new JSONObject(json);
                    Map<String,Object> Store1MenuResult= gson.fromJson
                            (jsonObject.get("Store1MenuResult").toString(),new TypeToken<Map<String, Object>>(){}.getType());

                    ArrayList<Map<String, Object>> store1_menuArrayList = (ArrayList) Store1MenuResult.get("STORE1_MENU");

                    tv.setText(tv.getText() + Store1MenuResult.get(0).toString()+"\n");
                    tv.setText(tv.getText() + Store1MenuResult.get(1).toString()+"\n");
                    tv.setText(tv.getText() + Store1MenuResult.get(2).toString()+"\n");

                    */
                /*
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                */





                //tv.setText(tv.getText() + jsonElement.getClass().getName() + "\n");
                //tv.setText(tv.getText() + ((JsonObject) jsonElement).get("language").getClass().getName() + "\n");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        stringRequest.setTag(TAG);
        queue.add(stringRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }



/*
        RequestQueue queue = Volley.newRequestQueue(this);
        // Request를 요청 할 URL

        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JsonParser jsonParser = new JsonParser();

                            String id = response.getString("id");
                            String menuName = response.getString("menuName");
                            int price = response.getInt("price");
                            int grams = response.getInt("grams");

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"메뉴 불러오기 실패.",Toast.LENGTH_SHORT).show();
            }
        });
        // queue에 Request를 추가해준다.
        queue.add(jsonObjectRequest);

 */


/*        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

        FragmentManager fm = getSupportFragmentManager();
        FragmentMenu1 fragment = (FragmentMenu1) fm.findFragmentById(R.id.viewpager);

        ZoomImage zoomImage = new ZoomImage();
        zoomImage.*/





    public void toHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}