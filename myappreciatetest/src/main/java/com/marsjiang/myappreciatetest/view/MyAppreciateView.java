package com.marsjiang.myappreciatetest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * 自定义点赞按钮
 * Created by Jiang on 2017-07-20.
 */

public class MyAppreciateView extends View {
    private Context context;
    private Paint paintBack = null;
    private Paint paintFront = null;
    private int allNumber;
    private int currentNumber;

    public MyAppreciateView(@NonNull Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public MyAppreciateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public MyAppreciateView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    /**
     * 设置总数量
     */
    public void setAllNumber(int allNumber) {
        this.allNumber = allNumber;
        invalidate();
    }

    /**
     * 设置当前数量
     */
    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
        invalidate();
    }

    /**
     * 增加数量
     */
    public void addNumber() {
        currentNumber++;
        if (currentNumber > allNumber) {
            currentNumber = allNumber;
            Toast.makeText(context, "数量已经达到最大！", Toast.LENGTH_SHORT).show();
            return;
        }
        invalidate();
    }

    /**
     * 减少数量
     */
    public void subNumber() {
        currentNumber--;
        if (currentNumber < 0) {
            currentNumber = 0;
            Toast.makeText(context, "数量已经达到最小！", Toast.LENGTH_SHORT).show();
            return;
        }
        invalidate();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        initViews();
    }

    private void initViews() {
        paintBack = new Paint();
        paintBack.setColor(Color.RED);
        paintBack.setStyle(Paint.Style.FILL);

        paintFront = new Paint();
        paintFront.setColor(Color.GREEN);
        paintFront.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(getMeasuredHeight() / 2, 0, getMeasuredWidth() - getMeasuredHeight() / 2, getMeasuredHeight(), paintBack);
        canvas.drawRect(getMeasuredHeight() / 2, 0, (float) (getMeasuredWidth() * (currentNumber / (allNumber * 1.0))) - getMeasuredHeight() / 2, getMeasuredHeight(), paintFront);
        //最左边的圆形
        if (currentNumber == 0) {
            canvas.drawCircle(getMeasuredHeight() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paintBack);
        } else {
            canvas.drawCircle(getMeasuredHeight() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paintFront);
        }
        //最右边的圆形
        if (currentNumber == allNumber) {
            canvas.drawCircle(getMeasuredWidth() - getMeasuredHeight() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paintFront);
        } else {
            canvas.drawCircle(getMeasuredWidth() - getMeasuredHeight() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paintBack);
        }
        //赞同最右边的圆
        canvas.drawCircle((float) (getMeasuredWidth() * (currentNumber / (allNumber * 1.0)) - getMeasuredHeight() / 2), getMeasuredHeight() / 2, getMeasuredHeight() / 2, paintFront);
        invalidate();
    }
    //测试分支1

}
