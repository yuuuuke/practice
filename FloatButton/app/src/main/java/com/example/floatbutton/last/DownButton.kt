package com.example.floatbutton.last

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DownButton : View {

    private var mHeight = 0
    private var mWidth = 0

    //边框的画笔
    private var mFramePaint = Paint()
    //进度条的画笔
    private var mProgressPaint = Paint()

    private var rect = RectF()

    private var mRadius = 20F

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        mFramePaint.style = Paint.Style.STROKE
        mFramePaint.color = Color.BLUE
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        rect.set(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
        mHeight = top - bottom
        mWidth = right - left
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            drawFrame(it)
            drawDownloadProgress(it)
        }
    }

    /**
     * 画边框
     */
    private fun drawFrame(canvas: Canvas) {
        canvas.drawRoundRect(rect, mRadius, mRadius, mFramePaint)
    }

    private fun drawDownloadProgress(canvas: Canvas?) {

    }
}