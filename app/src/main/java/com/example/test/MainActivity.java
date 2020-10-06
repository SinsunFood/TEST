package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void sendMessage1(View view){ // button1로의 반찬가게 이동
            Intent intent = new Intent(getApplicationContext(), MainActivityButton1.class);
            startActivity(intent);
        }

        public void sendMessage2(View view){ // button2로의 반찬가게 이동
            Intent intent = new Intent(getApplicationContext(), MainActivityButton2.class);
            startActivity(intent);
        }

        public void sendMessage3(View view){ // button3로의 반찬가게 이동
            Intent intent = new Intent(getApplicationContext(), MainActivityButton3.class);
            startActivity(intent);
        }
}