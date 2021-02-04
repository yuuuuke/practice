package com.example.floatbutton.function3

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.floatbutton.R

/**
 * description:高斯模糊？？
 *
 * @author zwp
 * @since 2021/1/28
 */
class BlurView : View {
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint()

    var mBitmap: Bitmap? = null
        set(value) {
            field = value
            invalidate()
        }

    init {
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = 5F
        mPaint.maskFilter = BlurMaskFilter(1000f, BlurMaskFilter.Blur.NORMAL)
        mPaint.color = context.resources.getColor(R.color.bg_blur_color)
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitmap?.let {
            canvas?.drawBitmap(it, Rect(0,0,width,height),Rect(0,0,700,700),  mPaint)
//            canvas?.drawRect(0F,0F, 100F, 100F, mPaint)
        }
    }
}