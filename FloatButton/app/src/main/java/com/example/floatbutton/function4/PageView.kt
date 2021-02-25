package com.example.floatbutton.function4

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * description:书页
 *
 * @author zwp
 * @since 2021/1/28
 */
class PageView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint()
    private var mAnimatorIsRunning = false
    private lateinit var animator: ObjectAnimator

    private var mTouchX = 0F
    private var mTouchY = 0F

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5F
        mPaint.color = Color.BLACK
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (mAnimatorIsRunning) {
            return true
        }
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_MOVE -> {
                    //记录按下的点
                    mTouchX = event.x
                    mTouchY = event.y
                }
                MotionEvent.ACTION_UP -> {
                    mTouchX = -1F
                }
            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        if (mTouchX <= 0) {
            //越界或无了
        } else {
            canvas?.let {
                it.save()
                it.translate(width.toFloat(), height.toFloat())
                it.rotate(180F)
                mTouchX = width - mTouchX
                mTouchY = height - mTouchY
                it.drawLine(
                    0F,
                    mTouchX * mTouchX / mTouchY / 2F + mTouchY / 2F,
                    mTouchX,
                    mTouchY,
                    mPaint
                )

                it.drawLine(
                    mTouchY * mTouchY / mTouchX / 2F + mTouchX / 2F,
                    0F,
                    mTouchX,
                    mTouchY,
                    mPaint
                )


                it.drawLine(
                    0F,
                    mTouchX * mTouchX / mTouchY / 2F + mTouchY / 2F,
                    mTouchY * mTouchY / mTouchX / 2F + mTouchX / 2F,
                    0F,
                    mPaint
                )

                it.restore()
            }

        }
        super.onDraw(canvas)
    }
}