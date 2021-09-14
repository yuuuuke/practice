package com.example.floatbutton.function10

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.abs

/**
 * description:测试一些API用的
 *
 * @author zwp
 * @since 2021/9/11
 */
class TestView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private val mPath = Path()
    private val mPaint = Paint()
    private val mPathMeasure: PathMeasure

    private val mDesPath = Path()

    private val pos: FloatArray = FloatArray(2)
    private val tan: FloatArray = FloatArray(2)

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.RED
        mPaint.strokeWidth = 10F

        mPath.moveTo(0f, 0f)
        mPath.quadTo(100f, 200f, 200f, 0f)
        mPath.quadTo(300f, -200f, 400f, 0f)

        mPathMeasure = PathMeasure(mPath, false)
        val lenght = mPathMeasure.length
        mPathMeasure.getPosTan(lenght / 2, pos, tan)
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            canvas.translate(400f, 400f)
            it.drawPath(mPath, mPaint)

            it.drawCircle(pos[0], pos[1], 10f, mPaint)
            Log.v("zwp", tan[0].toString() + "///" + tan[1])
        }
    }

}