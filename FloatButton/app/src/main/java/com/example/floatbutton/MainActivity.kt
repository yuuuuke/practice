package com.example.floatbutton

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.floatbutton.function1.Function1Activity
import com.example.floatbutton.function10.Function10Activity
import com.example.floatbutton.function11.Function11Activity
import com.example.floatbutton.function12.Function12Activity
import com.example.floatbutton.function13.Function13Activity
import com.example.floatbutton.function2.Function2Activity
import com.example.floatbutton.function3.Function3Activity
import com.example.floatbutton.function4.Function4Activity
import com.example.floatbutton.function5.Function5Activity
import com.example.floatbutton.function6.Function6Activity
import com.example.floatbutton.function7.Function7Activity
import com.example.floatbutton.function8.Function8Activity
import com.example.floatbutton.function9.Function9Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ServiceConnection {

    private lateinit var mAdapter: FunctionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.TRANSPARENT
        val frameLayout = findViewById<FrameLayout>(R.id.root_layout)
        frameLayout.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_STABLE
                or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        mAdapter = FunctionAdapter(this)
        function_list.adapter = mAdapter
        addView()
        val display = getWindowManager().getDefaultDisplay();
        val point = Point();
        display.getSize(point);
        val width = display.getWidth();
        val height = display.getHeight();
        Log.v("zwp","$width//"+height)
        val scale: Float = getResources().getDisplayMetrics().density
        Log.v("zwp","${height/scale+0.5f}///")
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

        val function9 = FunctionBean("点击跟踪") {
            startActivity(Intent(this, Function9Activity::class.java))
        }
        mAdapter.addData(function9)

        val function10 = FunctionBean("测试") {
            startActivity(Intent(this, Function10Activity::class.java))
        }
        mAdapter.addData(function10)

        val function11 = FunctionBean("DiffUtils") {
            startActivity(Intent(this, Function11Activity::class.java))
        }
        mAdapter.addData(function11)

        val function12 = FunctionBean("折叠布局") {
            startActivity(Intent(this, Function12Activity::class.java))
        }
        mAdapter.addData(function12)

        val function6 = FunctionBean("铁汁") {
            startActivity(Intent(this, Function6Activity::class.java))
        }
        mAdapter.addData(function6)

        val function13 = FunctionBean("LayoutManager") {
            startActivity(Intent(this, Function13Activity::class.java))
        }
        mAdapter.addData(function13)

//        Log.v("zwp", "Acname:" + Thread.currentThread().name + "/id:" + Thread.currentThread().id)
//        val function10 = FunctionBean("Service测试") {
//            bindService(Intent(this,MainService::class.java),this,0)
//        }
//        mAdapter.addData(function10)
//        lastCustomNonConfigurationInstance?.let{
//            Log.v("zwp",it.toString())
//        }
    }
//
//    private fun createIntentSender(): IntentSender {
//        val intent = Intent(this, MainActivity::class.java).apply {
//            action = ACTION_INSTALL
//        }
//        val pending = PendingIntent.getActivity(this, 0, intent, 0)
//        return pending.intentSender
//    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        TODO("Not yet implemented")
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        TODO("Not yet implemented")
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return "my name is lastConfiguration"
    }

    override fun onResume() {
        LogV("onResume")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        LogV("onDestroy")
        super.onDestroy()
    }
}
