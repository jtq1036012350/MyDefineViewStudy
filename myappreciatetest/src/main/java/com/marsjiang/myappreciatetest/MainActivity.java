package com.marsjiang.myappreciatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marsjiang.myappreciatetest.view.MyAppreciateView;

public class MainActivity extends AppCompatActivity {
    private Button btn_add;
    private Button btn_sub;
    private MyAppreciateView myAppreciateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        myAppreciateView = (MyAppreciateView) findViewById(R.id.myAppreciateView);
        btn_add = (Button) findViewById(R.id.btn_plus);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAppreciateView.addNumber();
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAppreciateView.subNumber();
            }
        });

        myAppreciateView.setAllNumber(10);
        myAppreciateView.setCurrentNumber(5);
    }
}
