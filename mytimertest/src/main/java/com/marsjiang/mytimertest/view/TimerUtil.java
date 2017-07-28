package com.marsjiang.mytimertest.view;

import android.os.CountDownTimer;
import android.widget.Button;

import com.marsjiang.mytimertest.R;


/**
 * 定时器
 */
public class TimerUtil extends CountDownTimer {
    /**
     * 获取验证码按钮对象
     */
    private Button btn_code;
    private long countDownInterval;
    private String hint;

    /**
     * 定时总时间
     * 执行时间间隔
     * 获取验证码按钮
     */

    public TimerUtil(Button btn_code, String hint,int time) {
        super(10 * 1000 - 1, time);
        this.btn_code = btn_code;
        this.hint = hint;
        this.countDownInterval = time;
    }

    @Override
    public void onFinish() {
        btn_code.setBackgroundResource(R.drawable.btn_submit_green);
        btn_code.setEnabled(true);
        btn_code.setClickable(true);
        btn_code.setText(hint);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btn_code.setEnabled(false);        //已经剥药的话就不允许再次点击
        btn_code.setBackgroundResource(R.drawable.btn_submit_grey);
        btn_code.setText(millisUntilFinished / countDownInterval + "秒");
    }

    public void stop() {
        this.cancel();
        this.onFinish();
    }

}
