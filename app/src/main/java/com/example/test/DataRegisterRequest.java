package com.example.test;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DataRegisterRequest extends StringRequest {
    //서버 url 설정(php 파일연동)
    final static  private  String URL = "http://whthakd.dothome.co.kr/RegisterData.php";
    private Map<String, String> map;




    public DataRegisterRequest(String Data1, String Data2, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap();
        map.put("Data1",Data1);
        map.put("Data2",Data2);

    }

}
