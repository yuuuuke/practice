package com.example.floatbutton.last

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.PixelFormat
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.view.animation.DecelerateInterpolator
import com.example.floatbutton.R
import kotlin.math.abs

class FloatButtonHelper(private val mActivity: Activity, private val doClick: () -> Unit) {


    companion object {
        const val MinMoveDistance = 10
    }

    private val mManager: WindowManager by lazy {
        mActivity.windowManager
    }

    private val mParams by lazy {
        WindowManager.LayoutParams().apply {
            width = dp2px(mActivity, 50f).toInt()
            height = dp2px(mActivity, 50f).toInt()
            type = WindowManager.LayoutParams.TYPE_APPLICATION
            flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            gravity = Gravity.CENTER_VERTICAL or Gravity.START
            windowAnimations = android.R.style.Animation_Translucent
            format = PixelFormat.RGBA_8888
        }
    }

    private lateinit var mHandler: Handler
    private lateinit var view:View
    fun showButton() {
        if (Looper.getMainLooper().thread.id != Thread.currentThread().id) {
            throw IllegalAccessException("请在主线程调用此方法")
        }
        mHandler = object : Handler(mActivity.mainLooper) {
            override fun handleMessage(msg: Message) {

            }
        }
        view =  LayoutInflater.from(mActivity).inflate(R.layout.layout_float_button, null)
        mManager.addView(view, mParams)
        setViewFunction(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setViewFunction(view: View) {
        var lastX = 0F
        var lastY = 0F
        var relateStartX = 0F
        var relateStartY = 0F
        var isMoveMotion = false
        val location = IntArray(2)
        val animator: ObjectAnimator? = ObjectAnimator.ofFloat(this, "tranX", 100F, 0F)
        animator?.interpolator = DecelerateInterpolator()
        view.setOnTouchListener { v, event ->
            event?.let {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        isMoveMotion = false
                        lastX = it.rawX
                        lastY = it.rawY
                        relateStartX = it.x
                        relateStartY = it.y
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if (abs(it.x - relateStartX) > MinMoveDistance || abs(it.y - relateStartY) > MinMoveDistance || isMoveMotion) {
                            //判定为移动
                            isMoveMotion = true
                            Log.v("zwp","${mParams.x}//${it.rawX.toInt()}//${lastX.toInt()}")
                            mParams.x = mParams.x + it.rawX.toInt() - lastX.toInt()
                            mParams.y = mParams.y + it.rawY.toInt() - lastY.toInt()
                            mManager.updateViewLayout(view, mParams)
                            lastX = it.rawX
                            lastY = it.rawY
                        } else {

                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        lastX = 0F
                        lastY = 0F
                        relateStartX = 0F
                        relateStartY = 0F
                        mFinalX = 0
                        x = 0
                        if (!isMoveMotion) {
                            doClick.invoke()
                        } else {
                            view.getLocationOnScreen(location)
                            val out = DisplayMetrics()
                            mManager.defaultDisplay.getMetrics(out)
                            val width = out.widthPixels
                            if (location[0] == 0 || location[0] == (width.minus(
                                    view.width
                                ))
                            ) {
                                //边缘
                                mHandler.sendMessageDelayed(Message(), 2000)
                            } else {
                                //不在边缘,执行动画
                                if (location[0] < width / 2) {
                                    //回到左边
                                    mFinalX = location[0]
                                    isLeft = true
                                    animator?.setDuration(1000)?.start()
                                } else {
                                    //回到右边
                                }
                            }
                        }
                        isMoveMotion = false
                    }
                    else -> ""
                }
            }
            false
        }
    }

    private var mFinalX = 0

    private var isLeft = true

    private var x = 0
    fun setTranX(value: Float) {
        if(value == 0F){
            return
        }
        if(x == 0){
            x = mFinalX
            return
        }
        if (isLeft) {
            mParams.x = mParams.x - x + (value/100F * mFinalX).toInt()
            mManager.updateViewLayout(view,mParams)
        } else {

        }
        x = (value/100F * mFinalX).toInt()
    }
}