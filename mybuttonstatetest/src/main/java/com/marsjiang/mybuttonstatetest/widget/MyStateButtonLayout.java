package com.marsjiang.mybuttonstatetest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.marsjiang.mybuttonstatetest.R;


/**
 * 合格不合格按钮封装
 * Created by Jiang on 2017-08-24.
 */

public class MyStateButtonLayout extends LinearLayout {
    //被选中时候的颜色
    private int colorEnable;

    private float allTextSize;

    private Button btn_qualified;
    private Button btn_unqualified;

    private OnQualifiedClickListener onQualifiedClickListener;
    private OnUnQualifiedClickListener onUnQualifiedClickListener;

    public interface OnQualifiedClickListener {
        void qualifiedClick();
    }

    public interface OnUnQualifiedClickListener {
        void unQualifiedClick();
    }

    public void setOnQualifiedClickListener(OnQualifiedClickListener onQualifiedClickListener) {
        this.onQualifiedClickListener = onQualifiedClickListener;
    }

    public void setOnUnQualifiedClickListener(OnUnQualifiedClickListener onUnQualifiedClickListener) {
        this.onUnQualifiedClickListener = onUnQualifiedClickListener;
    }


    public MyStateButtonLayout(Context context) {
        super(context);
    }

    public MyStateButtonLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyStateButtonLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化
     */
    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StateButtonLayout);
        colorEnable = ta.getColor(R.styleable.StateButtonLayout_colorEnable, getResources().getColor(R.color.colorQualifiedBlue));
        allTextSize = ta.getDimension(R.styleable.StateButtonLayout_allTextSize, 14);
        ta.recycle();

        initViews(context);

    }

    /**
     * 初始化布局
     */
    private void initViews(Context context) {
        View view = View.inflate(context, R.layout.state_button_layout, null);
        this.addView(view);
        btn_qualified = (Button) view.findViewById(R.id.btn_qualified);
        btn_unqualified = (Button) view.findViewById(R.id.btn_unqualified);

        btn_qualified.setTextSize(allTextSize);
        btn_unqualified.setTextSize(allTextSize);

        btn_qualified.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onQualifiedClickListener != null) {
                    onQualifiedClickListener.qualifiedClick();
                }
            }
        });
        btn_unqualified.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onUnQualifiedClickListener != null) {
                    onUnQualifiedClickListener.unQualifiedClick();
                }
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initQualifiedMeasure();
    }

    private void initQualifiedMeasure() {
        btn_qualified.setWidth(this.getMeasuredWidth());
        btn_qualified.setHeight((int) allTextSize);

        btn_unqualified.setWidth(this.getMeasuredWidth());
        btn_unqualified.setHeight((int) allTextSize);
    }

    public void setBtn_qualified() {
        btn_qualified.setBackgroundColor(colorEnable);
        btn_unqualified.setBackgroundColor(getResources().getColor(R.color.colorQualifiedWhite));
    }

    public void setBtn_unqualified() {
        btn_unqualified.setBackgroundColor(colorEnable);
        btn_qualified.setBackgroundColor(getResources().getColor(R.color.colorQualifiedWhite));
    }
}
