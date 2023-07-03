package com.example.floatbutton.function15

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CardRecyclerView : RecyclerView {

    private var mLayoutManager: CardLayoutManager = CardLayoutManager()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        layoutManager = mLayoutManager
        mLayoutManager.onFinished = {
            Toast.makeText(context,"数据查看完毕",Toast.LENGTH_SHORT).show()
        }
        onFlingListener = object:OnFlingListener(){
            override fun onFling(velocityX: Int, velocityY: Int): Boolean {
                // 屏蔽Fling事件
                mLayoutManager.doAnimation()
                return true
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(e: MotionEvent?): Boolean {
        // 当动画执行的时候，不让点击
        if(mLayoutManager.isAnimation){
            return true
        }
        return super.onTouchEvent(e)
    }
}