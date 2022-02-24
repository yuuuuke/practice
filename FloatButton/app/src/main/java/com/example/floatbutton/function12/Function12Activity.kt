package com.example.floatbutton.function12

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.layout_function12.*

/**
 * description:深入学习一下折叠布局使用
 *
 * @author zwp
 * @since 2021/9/28
 */
class Function12Activity:FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_function12)

        btn_easy.setOnClickListener {
            startActivity(Intent(this,CoordinatorActivity::class.java))
        }

        btn_normal.setOnClickListener {
            startActivity(Intent(this,CoordinatorNormalActivity::class.java))
        }

        btn_hard.setOnClickListener {
            startActivity(Intent(this,CoordinatorHardActivity::class.java))
        }
    }
}