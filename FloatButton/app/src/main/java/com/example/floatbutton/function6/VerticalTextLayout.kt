package com.example.floatbutton.function6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.StringBuilder
import kotlin.math.abs


public class VerticalTextLayout : View {

    private val mPaint: Paint = Paint()
    private val mSize: Float = 50f
    private val mColor: Int = Color.BLACK
    var mText: String? = null
        set(value) {
            field = value
            this.invalidate()
        }

    private var mBaseLine = 0F
    private val mTextHeight: Float
    private var mTempText: StringBuilder = StringBuilder()

    //baseline 离 top 的距离
    private var mTopLine = 0f

    //文字间距
    private val mTextSpace = 10f

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        mPaint.apply {
            strokeWidth = 20f
            textSize = mSize
            color = mColor
        }
        val fontMetrics = mPaint.fontMetrics
        mTextHeight = -fontMetrics.top + fontMetrics.descent + fontMetrics.leading - mTextSpace

        mTopLine = abs(fontMetrics.top)
        mBaseLine = mTopLine
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return
        mText?.let {
            for (c: Char in it) {
                if (c.code in 0x4e00..0x29FA5) {
                    //是中文
                    if (mTempText.toString().isNotEmpty()) {
                        //先把之前的画了
                        drawEnglish(mTempText.toString(), canvas)
                        mTempText.clear()
                    }
                    //然后再画中文
                    drawChinese(c.toString(), canvas)
                } else {
                    //别的符号
                    mTempText.append(c)
                }
            }

            if (mTempText.toString().isNotEmpty()) {
                //把剩下的画上去
                drawEnglish(mTempText.toString(), canvas)
                mTempText.clear()
            }
            mBaseLine = mTopLine
        }
    }

    private fun drawChinese(text: String, canvas: Canvas) {
        canvas.drawText(text, 0f, mBaseLine, mPaint)
        mBaseLine += mTextHeight
    }

    private fun drawEnglish(text: String, canvas: Canvas) {
        canvas.save()
        canvas.rotate(90f, 0f, mBaseLine - mTopLine)
        canvas.translate(0f, -mTextHeight - mTextSpace)
        canvas.drawText(text, 0f, mBaseLine, mPaint)
        canvas.restore()
        mBaseLine += mPaint.measureText(text)
    }
}