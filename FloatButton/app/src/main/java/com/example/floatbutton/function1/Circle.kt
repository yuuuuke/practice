package com.example.floatbutton.function1

import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.view.animation.DecelerateInterpolator

data class Circle(var x: Int, var y: Int) {

    private val animator: ObjectAnimator = ObjectAnimator.ofFloat(this, "circleRound", 0f, 100f)

    var isStart = false
    var round: Float = 0F
    var alpha: Float = 0F
    var color: Int = 0

    init {
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                isStart = false
            }

            override fun onAnimationCancel(animation: Animator?) {
                isStart = false
            }

            override fun onAnimationStart(animation: Animator?) {
                isStart = true
            }

        })
    }


    public fun startAnimator() {
        color = Color.rgb(
            (Math.random() * 255).toFloat(),
            (Math.random() * 255).toFloat(),
            (Math.random() * 255).toFloat()
        )
        animator.apply {
            interpolator = DecelerateInterpolator()
            setDuration(1000).start()
        }
    }

    private fun setCircleRound(value: Float) {
        round = value*2
        alpha = (100 - value) / 100F * 255
    }

    fun setLocation(xx: Int, yy: Int) {
        x = xx
        y = yy
    }
}