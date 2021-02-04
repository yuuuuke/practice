package com.example.floatbutton.function3

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.layout_function3.*

/**
 * description:模糊图层控件
 *
 * @author zwp
 * @since 2021/1/28
 */
class Function3Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_function3)


        show.setOnClickListener {
            blur_view.visibility = View.VISIBLE
            val bitmap = Bitmap.createBitmap(
                bg.width,
                bg.height,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            bg.draw(canvas)
            blur_view.mBitmap = bitmap
        }
    }
}