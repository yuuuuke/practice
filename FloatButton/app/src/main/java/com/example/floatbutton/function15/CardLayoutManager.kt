package com.example.floatbutton.function15

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class CardLayoutManager : LayoutManager() {

    var index = 0
    var isAnimation = false

    // 最后一个也划完了
    var onFinished: (() -> Unit)? = null

    //计算测量布局的宽高
    private var mDecoratedChildWidth = 0
    private var mDecoratedChildHeight = 0

    private lateinit var firstView: View
    private lateinit var secondView: View

    // 偏移值
    private var mSumDx = 0

    companion object{
        // 第二层item的缩小和透明度属性
        const val SCALE_X = 0.9F
        const val SCALE_Y = 0.9F
        const val ALPHA = 0.5F

        // 第一层item的旋转中心
        const val CENTER_X = 400f
        const val CENTER_Y = 3000f
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State?) {

        if(index == itemCount -1){
            onFinished?.invoke()
            return
        }

        if(index != itemCount -2){
            secondView = recycler.getViewForPosition(index+1)
            addView(secondView)
            measureChildWithMargins(secondView, 0, 0)
            if(mDecoratedChildWidth == 0){
                mDecoratedChildWidth = getDecoratedMeasuredWidth(secondView)
                mDecoratedChildHeight = getDecoratedMeasuredHeight(secondView)
            }
            layoutDecorated(secondView, 0, 0, mDecoratedChildWidth, mDecoratedChildHeight)
        }

        firstView = recycler.getViewForPosition(index)
        addView(firstView)
        measureChildWithMargins(firstView, 0, 0)
        layoutDecorated(firstView, 0, 0, mDecoratedChildWidth, mDecoratedChildHeight)
    }

    override fun canScrollHorizontally(): Boolean {
        return true
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State?
    ): Int {
        mSumDx += dx
        detachAndScrapAttachedViews(recycler)
        layoutPosition(recycler, mSumDx)
        return dx
    }

    private fun layoutPosition(recycler: RecyclerView.Recycler, offset: Int) {
        if(index == itemCount -1){
            return
        }

        if(index != itemCount -2){
            addView(secondView)
            measureChildWithMargins(secondView, 0, 0)
            layoutDecorated(secondView, 0, 0, mDecoratedChildWidth, mDecoratedChildHeight)
            secondView.scaleX = SCALE_X
            secondView.scaleY = SCALE_Y
            secondView.alpha = ALPHA
        }

        addView(firstView)
        measureChild(firstView, 0, 0);
        layoutDecorated(firstView, 0, 0, mDecoratedChildWidth, mDecoratedChildHeight)
        firstView.pivotX = CENTER_X
        firstView.pivotY = CENTER_Y
        firstView.rotation = -offset / 30f
    }


    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
        when (state) {
            RecyclerView.SCROLL_STATE_IDLE ->
                doAnimation()
            RecyclerView.SCROLL_STATE_DRAGGING -> {}
            RecyclerView.SCROLL_STATE_SETTLING -> {}
        }
    }

    fun doAnimation() {
        isAnimation = true
        var radius = 0f
        if (mSumDx >= 300) {
            radius = -70f
        } else if (mSumDx <= -300) {
            radius = 70f
        }
        firstView.animate().rotation(radius).setDuration(500)
            .setListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    mSumDx = 0
                    if (radius != 0f) {
                        // 第二个界面执行动画
                        secondView.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(500)
                            .setListener(object : AnimatorListener {
                                override fun onAnimationStart(animation: Animator?) {
                                }

                                override fun onAnimationEnd(animation: Animator?) {
                                    isAnimation = false
                                    index++
                                    removeView(firstView)
                                }

                                override fun onAnimationCancel(animation: Animator?) {
                                }

                                override fun onAnimationRepeat(animation: Animator?) {
                                }

                            }).start()
                    }else{
                        isAnimation = false
                    }
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }
            }).start()
    }
}