package com.example.floatbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.floatbutton.function1.Function1Activity
import com.example.floatbutton.function2.Function2Activity
import com.example.floatbutton.function3.Function3Activity
import com.example.floatbutton.function4.Function4Activity
import com.example.floatbutton.function5.Function5Activity
import com.example.floatbutton.function7.Function7Activity
import com.example.floatbutton.function8.Function8Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: FunctionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = FunctionAdapter(this)
        function_list.adapter = mAdapter
        addView()
    }

    private fun addView() {
        val function1 = FunctionBean("七彩光圈") {
            startActivity(Intent(this, Function1Activity::class.java))
        }
        mAdapter.addData(function1)

        val function2 = FunctionBean("水波纹") {
            startActivity(Intent(this, Function2Activity::class.java))
        }
        mAdapter.addData(function2)

        val function3 = FunctionBean("蜘蛛网") {
            startActivity(Intent(this, Function3Activity::class.java))
        }
        mAdapter.addData(function3)

        val function4 = FunctionBean("翻页效果") {
            startActivity(Intent(this, Function4Activity::class.java))
        }
        mAdapter.addData(function4)

        val function5 = FunctionBean("圆角Drawable") {
            startActivity(Intent(this, Function5Activity::class.java))
        }
        mAdapter.addData(function5)

        val function7 = FunctionBean("分组列表") {
            startActivity(Intent(this, Function7Activity::class.java))
        }
        mAdapter.addData(function7)

        val function8 = FunctionBean("画") {
            startActivity(Intent(this, Function8Activity::class.java))
        }
        mAdapter.addData(function8)
    }
}
