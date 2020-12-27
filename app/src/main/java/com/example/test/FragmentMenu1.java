package com.example.test;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

/**
 * A fragment representing a list of Items.
 */
public class FragmentMenu1 extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private RequestQueue queue;
    final ArrayList<Menu> items = new ArrayList<>();


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentMenu1() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentMenu1 newInstance(int columnCount) {
        FragmentMenu1 fragment = new FragmentMenu1();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        MenuAdapter adapter = new MenuAdapter();

        // Set the adapter
        if (view instanceof RecyclerView) {

            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new GridLayoutManager(context,3));

            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));

            }
            recyclerView.setAdapter(adapter);
            //////////////////////////////////////////////
            // string request
            final Gson gson = new Gson();
            queue = Volley.newRequestQueue(this.getContext());
            String url = "http://whthakd.dothome.co.kr/get_Store1MenuData.php";
            final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // get으로 DB에서 매장 메뉴 정보들 불러와서 메뉴Array에 저장
                    try {
                        JsonParser jsonParser = new JsonParser();
                        JsonObject jsonObject = (JsonObject) jsonParser.parse(response); //json 전체 파싱
                        JsonArray jsonArray = jsonObject.getAsJsonArray("STORE_MENU");

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JsonElement jsonElement = jsonArray.get(i);
                            Menu menu = gson.fromJson(jsonElement.toString(), Menu.class);
                            items.add(i, menu); // 메뉴 리스트 저장
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            queue.add(stringRequest); // 매장 메뉴 정보 불러옴


            adapter.setItems(items);

        }
        return view;
    }
}