package com.example.floatbutton.function3

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.abs

/**
 * description:动态蜘蛛网的效果
 *
 * @author zwp
 * @since 2021/3/17
 */
class SpiderWebView : View {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint()

    private val list: ArrayList<Node> = ArrayList()

    private val effect = DashPathEffect(FloatArray(2) { 2F;2F }, 0F)

    init {
        post {
            //添加一百个节点
            for (i in 0 until 100) {
                //随机两个坐标
                val x = Math.random() * width
                val y = Math.random() * height
                //随机两个横竖方向上的速度
                val xSpeed = Math.random() * 4
                val ySpeed = Math.random() * 4
                //随机颜色
                val color = Color.rgb(
                    (Math.random() * 255).toFloat(),
                    (Math.random() * 255).toFloat(),
                    (Math.random() * 255).toFloat()
                )
                list.add(Node(x.toInt(), y.toInt(), xSpeed.toInt() - 2, ySpeed.toInt() - 2, color))
            }
            startMoveAnimation()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        if (list.size == 0) {
            return
        }
        canvas?.let {
            for (node in list) {
                mPaint.color = node.color
                canvas.drawCircle(node.x.toFloat(), node.y.toFloat(), 5F, mPaint)
            }

            mPaint.pathEffect = effect
            mPaint.color = Color.RED
            for (i in 0 until list.size) {
                for (j in i until list.size) {
                    if (abs(list[i].x - list[j].x) < 200 && abs(list[i].y - list[j].y) < 200) {
                        canvas.drawLine(
                            list[i].x.toFloat(),
                            list[i].y.toFloat(),
                            list[j].x.toFloat(),
                            list[j].y.toFloat(),
                            mPaint
                        )
                    }
                }
            }
            mPaint.pathEffect = null
        }
    }

    private fun startMoveAnimation() {
        val animator = ValueAnimator.ofFloat(0F, 100F)
        animator.addUpdateListener {
            for (node in list) {
                node.x = node.x + node.xSpeed
                node.y = node.y + node.ySpeed

                if ((node.x > width) or (node.x < 0)) {
                    node.xSpeed = -node.xSpeed
                }
                if ((node.y > height) or (node.y < 0)) {
                    node.ySpeed = -node.ySpeed
                }
            }
            invalidate()
        }
        animator.duration = 2000
        animator.repeatCount = -1
        animator.start()
    }
}