package com.example.floatbutton.function5;

/**
 * description:
 *
 * @author zwp
 * @since 2021/10/18
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * description:下载进度条
 *
 * @author zwp
 * @since 2021/10/18
 */
class FOUpgradeProgressBar extends View {

    private int height = 0;
    private int width = 0;

    private Paint mPaint = new Paint();
    private RectF rectF = new RectF();

    private RectF progressRectF = new RectF();

    private int backgroundColor = Color.parseColor("#F6BE60");
    private int progressColor = Color.parseColor("#FEEEBB");

    public FOUpgradeProgressBar(Context context) {
        this(context, null);
    }

    public FOUpgradeProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FOUpgradeProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        height = top - bottom;
        width = right - left;
        rectF.top = 0;
        rectF.left = 0;
        rectF.bottom = height;
        rectF.right = width;

        progressRectF.top = 0;
        progressRectF.left = 0;
        progressRectF.bottom = height;
        progressRectF.right = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (height == 0 || canvas == null) {
            return;
        }
        drawBackground(canvas);
        drawProgress(canvas);
    }

    //画进度条
    private void drawBackground(Canvas canvas) {
        mPaint.setColor(backgroundColor);
        canvas.drawRoundRect(rectF, 9, 9, mPaint);
    }

    private void drawProgress(Canvas canvas){
        mPaint.setColor(progressColor);
        canvas.drawRoundRect(progressRectF,9,9,mPaint);
    }

    public void setProgress(int progress){
        progressRectF.right = width * progress / 100F;
        postInvalidate();
    }
}

