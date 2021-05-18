package com.example.floatbutton.function8

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * description:有意思的画板
 *
 * @author zwp
 * @since 2021/3/19
 */
class MyDrawBoard : View {

    var mirrors = 4
        set(value) {
            field = value
            path.reset()
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    val path = Path()
    val mPaint: Paint by lazy {
        Paint()
    }

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5F
    }

    val point = PointF()

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    point.x = it.x
                    point.y = it.y
                    path.moveTo(it.x, it.y)
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    path.quadTo(point.x, point.y, (point.x + it.x) / 2, (point.y + it.y) / 2)
                    point.x = it.x
                    point.y = it.y
                }
                MotionEvent.ACTION_UP -> {
                    path.moveTo(it.x, it.y)
                }
            }
        }
        postInvalidate()
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawPath(path, mPaint)
//        canvas?.save()
//        canvas?.rotate(90F,width/2F,height/2F)
//        canvas?.drawPath(path, mPaint)
//        canvas?.save()
//        canvas?.rotate(90F,width/2F,height/2F)
//        canvas?.drawPath(path, mPaint)
//        canvas?.save()
//        canvas?.rotate(90F,width/2F,height/2F)
//        canvas?.drawPath(path, mPaint)
//
        if (mirrors in 1..20) {
            var i = 0
            canvas?.drawPath(path, mPaint)
            while (i < mirrors) {
                canvas?.save()
                canvas?.drawPath(path, mPaint)
                canvas?.rotate(360F / mirrors, width / 2F, height / 2F)
                i++
            }
        } else {
            return
        }
        super.onDraw(canvas)
    }
}
