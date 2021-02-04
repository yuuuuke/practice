package com.example.floatbutton.function1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CircleView : View {

    val paint: Paint
    val list: ArrayList<Circle>

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        paint = Paint()
        list = ArrayList()
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8F
    }

    override fun onDraw(canvas: Canvas?) {
        for(i in 0 until list.size){
            paint.color = list[i].color
            paint.alpha = list[i].alpha.toInt()
            canvas?.drawCircle(list[i].x.toFloat(),list[i].y.toFloat(),list[i].round,paint)
        }
        super.onDraw(canvas)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when (it.action) {
                MotionEvent.ACTION_MOVE -> {
                    val circle: Circle = createCircle(it.x.toInt(),it.y.toInt())
                    list.add(circle)
                    circle.startAnimator()
                }
                else -> ""
            }
        }
        return true
    }

    private fun createCircle(x:Int,y:Int): Circle {
        for(c in list){
            if(!c.isStart){
                c.setLocation(x,y)
                return c
            }
        }
        return Circle(x, y)
    }
}