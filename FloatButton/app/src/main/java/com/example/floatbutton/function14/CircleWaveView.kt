package com.example.floatbutton.function14

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class CircleWaveView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    private var basePointLength = Array<Int>(8) { 0 }
    private var basePoint = Array<Point>(8) { Point(0f, 0f) }
    private var controlPoint = Array<Point>(8) { Point(0f, 0f) }

    private val Paint = Paint()


    init {
        Paint.color = Color.RED
        Paint.style = android.graphics.Paint.Style.FILL
        Paint.strokeWidth = 4F
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width <= 0) return
        canvas.translate(width / 2f, height / 2f)
        drawWave(canvas,Color.RED,280,320)
        drawWave(canvas,Color.BLUE,200,260)
        drawWave(canvas,Color.BLACK,120,180)
        Paint.color = Color.YELLOW
        canvas.drawCircle(0f, 0f, 100f, Paint)
    }


    fun drawWave(canvas: Canvas, color: Int, inlineRadius: Int, outlineRadius: Int) {
        val Path = Path()
        Paint.color = color
        for (i in 0 until 8) {
            basePointLength[i] =
                inlineRadius + ((outlineRadius - inlineRadius) * Math.random()).toInt()
        }

        for (i in 25 until 360 step 45) {
            //初始化控制点
            controlPoint[i / 45].x = outlineRadius * sin(i.toDouble() * 2 * Math.PI / 360).toFloat()
            controlPoint[i / 45].y = outlineRadius * cos(i.toDouble() * 2 * Math.PI / 360).toFloat()
        }

        for (i in 0 until 360 step 45) {
            //初始化基点
            basePoint[i / 45].x =
                basePointLength[i / 45] * sin(i.toDouble() * 2 * Math.PI / 360).toFloat()
            basePoint[i / 45].y =
                basePointLength[i / 45] * cos(i.toDouble() * 2 * Math.PI / 360).toFloat()
        }

        Path.moveTo(basePoint[0].x, basePoint[0].y)
        for (i in 1 until 8) {
            Path.quadTo(
                controlPoint[i - 1].x,
                controlPoint[i - 1].y,
                basePoint[i].x,
                basePoint[i].y
            )
        }
        Path.quadTo(controlPoint[7].x, controlPoint[7].y, basePoint[0].x, basePoint[0].y)
        canvas.drawPath(Path, Paint)
    }
}