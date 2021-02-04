package com.example.floatbutton.function4

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.floatbutton.R

/**
 * description:书页
 *
 * @author zwp
 * @since 2021/1/28
 */
class PageView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint()

    init{
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = 5F
        mPaint.maskFilter = BlurMaskFilter(1000f, BlurMaskFilter.Blur.NORMAL)
        mPaint.color = context.resources.getColor(R.color.bg_blur_color)
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)
    }
}