package com.example.floatbutton.function9

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.*

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

    private val mPath = Path()

    private val rectHeight = 60
    private val rectWidth = 120

    //上个点的位置
    private var lastX = 0f
    private var lastY = 0f

    private var controlX = 0f
    private var controlY = 0f

    //目标点的位置
    private var targetX = 0f
    private var targetY = 0f

    //动态点的位置
    private val dynamicPos = FloatArray(2)

    //动态点的斜率
    private val dynamicTan = FloatArray(2)
    private var degrees = 0f

    lateinit var mPathMeasure: PathMeasure

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
                    mPath.reset()

                    lastX = targetX
                    lastY = targetY

                    targetX = event.x
                    targetY = event.y

                    //计算控制点 （简陋版）
//                    val controlX = lastX
//                    val controlY = targetY

                    calculateTargetAngle()

                    mPath.moveTo(lastX, lastY)
                    mPath.quadTo(controlX, controlY, targetX, targetY)
                    Log.v(
                        "zwp", "lastX = $lastX,lastY = $lastY" +
                                "controlX = $controlX,controlY = $controlY" +
                                "targetX = $targetX,targetY = $targetY"
                    )
                    mPathMeasure = PathMeasure(mPath, false)
                    //执行动画
                    animation.start()
                }
            }
        }
        return super.onTouchEvent(event)
    }

    //执行动画
    fun setDynamicTrack(percent: Float) {
        mPathMeasure.getPosTan(mPathMeasure.length * percent / 100f, dynamicPos, dynamicTan)
        degrees = (atan2(dynamicTan[1], dynamicTan[0]) * 180.0 / Math.PI).toFloat()
        invalidate()
    }

    //计算控制点的位置
    private fun calculateTargetAngle() {
        //先算控制点的角度
        val adjacentEdge = abs(targetX - lastX)
        val oppositeSide = abs(targetY - lastY)
        val tanTarget = adjacentEdge / oppositeSide
        val targetAngle = Math.toDegrees(atan(tanTarget.toDouble())).toFloat()

        //斜边
        val hypotenuse = sqrt(adjacentEdge * adjacentEdge + oppositeSide * oppositeSide)

        //控制点的偏移
        val offset = hypotenuse / cos(targetAngle.toDouble()) / 2

        //全部走上面
        controlX = if (targetX > lastX) (lastX + offset).toFloat() else (targetX + offset).toFloat()
        controlY =
            if ((targetX > targetY && lastX > lastY) || (targetX < targetY && lastX < lastY)) {
                if (targetX > lastX) lastY else targetY
            } else {
                if (targetX > lastX) targetY else lastY
            }
        Log.v("zwp", "controlX = $controlX , controlY = $controlY")
    }

    /**
     * 画鱼
     */
    private fun drawTarget(canvas: Canvas) {

//        canvas.rotate(degrees, dynamicPos[0], dynamicPos[1])
        canvas.drawPath(mPath, mPaint)

        //先画个方块
        canvas.drawRect(
            dynamicPos[0],
            dynamicPos[1] - rectHeight / 2,
            dynamicPos[0] + rectWidth,
            dynamicPos[1] + rectHeight / 2,
            mPaint
        )
        //头
        canvas.drawCircle(
            dynamicPos[0],
            dynamicPos[1],
            20f,
            mPaint
        )
    }
}