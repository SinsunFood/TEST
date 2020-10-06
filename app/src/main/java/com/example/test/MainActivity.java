package com.example.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =(Button)findViewById(R.id.btn_1);
        btn2 =(Button)findViewById(R.id.btn_2);
        btn3 =(Button)findViewById(R.id.btn_3);
        btn4 =(Button)findViewById(R.id.btn_4);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        tr.replace(R.id.frame,fragment1);

        tr.commit();

    }
});

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                tr.replace(R.id.frame,fragment2);

                tr.commit();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3= new Fragment3();
                tr.replace(R.id.frame,fragment3);

                tr.commit();

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
                Fragment4 fragment4 = new Fragment4();
                tr.replace(R.id.frame,fragment4);

                tr.commit();

            }
        });
    }
}