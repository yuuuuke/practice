package com.example.floatbutton.function9

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.abs

//import org.apache.comm

/**
 * description:手势跟踪
 *
 * @author zwp
 * @since 2021/7/26
 */
class TrackMotionView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val rectHeight = 60
    private val rectWidth = 120

    //上个点的位置
    private var lastX = 0f
    private var lastY = 0f
    private var lastAngle = 0f

    //目标点的位置
    private var targetX = 0f
    private var targetY = 0f
    private var targetAngle = 0f

    //动态点的位置
    private var dynamicX = 0f
    private var dynamicY = 0f
    private var dynamicAngle = 0f

    private val animation: ObjectAnimator =
        ObjectAnimator.ofFloat(this, "dynamicTrack", 0f, 100f).apply {
            interpolator = AccelerateDecelerateInterpolator()
            duration = 800
        }

    private val mPaint: Paint = Paint()

    init {
        mPaint.color = Color.RED
        mPaint.strokeWidth = 5f
        mPaint.style = Paint.Style.STROKE
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            drawTarget(it)
        }
        super.onDraw(canvas)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            if (animation.isRunning) {
                return@let
            }
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = targetX
                    lastY = targetY
                    //执行动画
                    targetX = event.x
                    targetY = event.y

                    lastAngle = targetAngle

                    calculateTargetAngle()

                    animation.start()
                }
            }
        }
        return super.onTouchEvent(event)
    }

    //执行动画
    fun setDynamicTrack(percent: Float) {
        dynamicX = (targetX - lastX) * percent / 100 + lastX
        dynamicY = (targetY - lastY) * percent / 100 + lastY
        dynamicAngle = (targetAngle - lastAngle) * percent / 100 + lastAngle
        invalidate()
    }

    private fun calculateTargetAngle() {
        val adjacentEdge = abs(targetX - lastX)
        val oppositeSide = abs(targetY - lastY)
        val tanTarget = adjacentEdge / oppositeSide
        targetAngle = Math.toDegrees(Math.atan(tanTarget.toDouble())).toFloat()

        targetAngle = if (targetX >= lastX) {
            if (targetY >= lastY) {
                180 - targetAngle
            } else {
                180 + targetAngle
            }
        } else {
            if (targetY >= lastY) {
                targetAngle
            } else {
                360 - targetAngle
            }
        }
        Log.v("Zwp", "angle = $targetAngle")
    }

    /**
     * 画鱼
     */
    private fun drawTarget(canvas: Canvas) {

        canvas.rotate(360 - dynamicAngle, dynamicX, dynamicY)
        Log.v("Zwp", "dynamicAngle = $dynamicAngle")
        //先画个方块
        canvas.drawRect(
            dynamicX,
            dynamicY - rectHeight / 2,
            dynamicX + rectWidth,
            dynamicY + rectHeight / 2,
            mPaint
        )
        //头
        canvas.drawCircle(
            dynamicX,
            dynamicY,
            20f,
            mPaint
        )
    }
}