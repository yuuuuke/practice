package com.example.floatbutton.function6

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.auto_move_layout.view.*

/**
 * description:字幕滚动的TextView
 *
 * @author zwp
 * @since 2021/2/19
 */
class AutoMoveTextLayout : LinearLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        LayoutInflater.from(context).inflate(R.layout.auto_move_layout,this)
        text1.
        post {

        }
    }
}