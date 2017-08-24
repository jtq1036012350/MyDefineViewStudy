package com.marsjiang.mybuttonstatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marsjiang.mybuttonstatetest.widget.MyStateButtonLayout;

public class MainActivity extends AppCompatActivity {
    private MyStateButtonLayout mystatebuttonlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mystatebuttonlayout = (MyStateButtonLayout) findViewById(R.id.mystatebuttonlayout);

        mystatebuttonlayout.setOnQualifiedClickListener(new MyStateButtonLayout.OnQualifiedClickListener() {
            @Override
            public void qualifiedClick() {
                Toast.makeText(MainActivity.this, "a", Toast.LENGTH_SHORT).show();
                mystatebuttonlayout.setBtn_qualified();
            }
        });

        mystatebuttonlayout.setOnUnQualifiedClickListener(new MyStateButtonLayout.OnUnQualifiedClickListener() {
            @Override
            public void unQualifiedClick() {
                Toast.makeText(MainActivity.this, "b", Toast.LENGTH_SHORT).show();
                mystatebuttonlayout.setBtn_unqualified();
            }
        });

    }
}
