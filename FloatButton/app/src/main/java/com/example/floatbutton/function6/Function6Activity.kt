package com.example.floatbutton.function6

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.layout_function5.*
import kotlinx.android.synthetic.main.layout_function5.iv
import kotlinx.android.synthetic.main.layout_function6.*

/**
 * description:drawable
 *
 * @author zwp
 * @since 2021/1/28
 */
class Function6Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_function6)

        vertical_text.post {
            vertical_text.mText = "我是中国人im chinese!!!!123456789我是中国人"
        }
    }
}