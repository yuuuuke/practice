package com.example.floatbutton.function5

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.layout_function5.*

/**
 * description:drawable
 *
 * @author zwp
 * @since 2021/1/28
 */
class Function5Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_function5)
//        iv.setImageDrawable(RadiusDrawable())


        input.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                Log.v("zwp", "hasFocus + $hasFocus")
            }
        })
    }
}