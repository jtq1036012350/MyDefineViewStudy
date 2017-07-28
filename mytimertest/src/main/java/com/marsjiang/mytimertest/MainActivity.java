package com.marsjiang.mytimertest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marsjiang.mytimertest.view.TimerUtil;

public class MainActivity extends AppCompatActivity {
    //定时器
    private TimerUtil timerUtil;
    private Button btn_start;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        timerUtil = new TimerUtil(btn_start, "Test",1000);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                timerUtil.stop();
            }
        };
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerUtil.start();
                Message message = Message.obtain();
                mHandler.sendMessageDelayed(message, 2000);
            }
        });
    }
}
