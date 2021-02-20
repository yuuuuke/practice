package com.example.floatbutton.function5

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.graphics.toRectF
import java.util.*

/**
 * description:圆角Drawable
 *
 * @author zwp
 * @since 2021/2/4
 */
class RadiusDrawable : Drawable() {

    private var mPaint = Paint()

    init {
        Base64.getEncoder()
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.BLACK
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRoundRect(bounds.toRectF(),20F,20F, mPaint)
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }
}