package com.example.floatbutton.function2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.floatbutton.R


/**
 * description:水波控件
 *
 * @author zwp
 * @since 2021/1/27
 */
class WaterWaveView : View {

    private val mPaint: Paint = Paint()
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    private var mGlassPath: Path = Path()
    private var mWave1Path: Path = Path()
    private var mWave2Path: Path = Path()

    private var offsetX = 0
    private var offsetY = 0

    var temp = 0
    var temp1 = 1

    private val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    private var dstBitmap: Bitmap
    private var srcBitmap: Bitmap

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 5F
        mPaint.style = Paint.Style.FILL_AND_STROKE
        dstBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        srcBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        drawSRCBitmap()
        drawDSTBitmap()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        mWidth = right - left
        mHeight = bottom - top
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            resetPath()
            clearPaint()
            val sc = canvas.saveLayer(0F, 0F, mWidth.toFloat(), mHeight.toFloat(), null)
            drawGlass()
            canvas.drawBitmap(dstBitmap, mWidth / 2f - 500, mHeight / 2f - 500, mPaint)
            drawWave()
            mPaint.xfermode = xfermode
            canvas.drawBitmap(srcBitmap, mWidth / 2f - 500 + temp, mHeight / 2f - 500, mPaint)
            canvas.restoreToCount(sc)


        }

        if (temp > 190) {
            temp1 = -1
        }
        if(temp<10){
            temp1 = 1
        }
        temp += temp1
        invalidate()
    }

    private fun clearPaint() {
        mPaint.reset()
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = 5F
        mPaint.style = Paint.Style.FILL_AND_STROKE
    }

    private fun resetPath() {
        mGlassPath.reset()
        mWave1Path.reset()
        mWave2Path.reset()
    }

    private fun drawGlass() {
        mGlassPath.moveTo(200F, 0F)
        mGlassPath.lineTo(200F, 800F)
        mGlassPath.lineTo(600F, 800F)
        mGlassPath.lineTo(600F, 0F)
        dstCanvas.drawPath(mGlassPath, mPaint)
    }

    private fun drawWave() {
        mPaint.color = context.resources.getColor(R.color.wave_color)
        mWave1Path.moveTo(0f + offsetX, 200f + offsetY)
        mWave1Path.quadTo(100f + offsetX, 150F + offsetY, 200f + offsetX, 200f + offsetY)
        mWave1Path.quadTo(300f + offsetX, 250f + offsetY, 400f + offsetX, 200f + offsetY)
        mWave1Path.quadTo(500f + offsetX, 150F + offsetY, 600F + offsetX, 200F + offsetY)
        mWave1Path.lineTo(600F + offsetX, 800F)
        mWave1Path.lineTo(0f + offsetX, 800f)
        mWave1Path.close()
        srcCanvas.drawPath(mWave1Path, mPaint)

//        mWave2Path.moveTo(0f + offsetX, 200f + offsetY)
//        mWave2Path.quadTo(100f + offsetX, 150F + offsetY, 200f + offsetX, 200f + offsetY)
//        mWave2Path.quadTo(300f + offsetX, 250f + offsetY, 400f + offsetX, 200f + offsetY)
//        mWave2Path.quadTo(500f + offsetX, 150F + offsetY, 600F + offsetX, 200F + offsetY)
//        mWave2Path.lineTo(600F + offsetX, 800F)
//        mWave2Path.lineTo(0f + offsetX, 800f)
//        mWave2Path.close()
//        srcCanvas.drawPath(mWave2Path, mPaint)

        mPaint.xfermode = null
    }

    lateinit var srcCanvas: Canvas
    lateinit var dstCanvas: Canvas

    private fun drawSRCBitmap() {
        srcCanvas = Canvas(srcBitmap)

    }

    private fun drawDSTBitmap() {
        dstCanvas = Canvas(dstBitmap)
    }
}