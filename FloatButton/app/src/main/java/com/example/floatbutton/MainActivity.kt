package com.example.floatbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import com.example.floatbutton.function1.Function1Activity
import com.example.floatbutton.function2.Function2Activity
import com.example.floatbutton.function3.Function3Activity
import com.example.floatbutton.function5.Function5Activity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdatepr: FunctionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdatepr = FunctionAdapter(this)
        function_list.adapter = mAdatepr

        addView()
    }

    private fun addView() {
        val function1 = FunctionBean("七彩光圈") {
            startActivity(Intent(this, Function1Activity::class.java))
        }
        mAdatepr.addData(function1)

        val function2 = FunctionBean("水波纹") {
            startActivity(Intent(this, Function2Activity::class.java))
        }
        mAdatepr.addData(function2)

        val function3 = FunctionBean("模糊？") {
            startActivity(Intent(this, Function3Activity::class.java))
        }
        mAdatepr.addData(function3)

        val function5 = FunctionBean("圆角Drawable") {
            startActivity(Intent(this, Function5Activity::class.java))
        }
        mAdatepr.addData(function5)
    }


}
