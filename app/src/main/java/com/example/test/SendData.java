package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class SendData extends AppCompatActivity {

    private EditText et_data1,et_data2;
    private Button btn_register_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);


//Data1,2 값찾아주기@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        et_data1 = findViewById(R.id.et_data1);
        et_data2 = findViewById(R.id.et_data2);


        //회원가입 버튼 클릭시 수행@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        btn_register_data = findViewById(R.id.btn_register_data);
        btn_register_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력값을 가져온다

                String Data1= et_data1.getText().toString();
                String Data2= et_data2.getText().toString();
                //int userAge= Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){//데이터 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"데이터 등록을 축하드립니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SendData.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(),"데이터 등록 실패.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 volly를 이용해서 요청함
                DataRegisterRequest dataRegisterRequest = new DataRegisterRequest(Data1, Data2,responseListener);
                RequestQueue queue = Volley.newRequestQueue(SendData.this);
                queue.add(dataRegisterRequest);




            }
        });
    }
}