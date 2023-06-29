package com.example.floatbutton.function11

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.floatbutton.R
import com.example.floatbutton.hook.hookOnClickListener

/**
 * description: DiffUtils 学习的 Demo
 *
 * @author zwp
 * @since 2021/9/15
 */
class Function11Activity : AppCompatActivity() {

    lateinit var list: RecyclerView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function11)

        val oldData = ArrayList<TestBean>()
        oldData.add(TestBean("张三", 20))
        oldData.add(TestBean("李四", 12))
        oldData.add(TestBean("王五", 22))
        oldData.add(TestBean("Mark", 23))
        oldData.add(TestBean("周七", 42))

        val newData = ArrayList<TestBean>()
        newData.add(TestBean("张三", 44))
        newData.add(TestBean("李四", 215))
        newData.add(TestBean("王五", 2341))
        newData.add(TestBean("赵六", 23))
        newData.add(TestBean("周七", 42))
        newData.add(TestBean("周七", 42))

        list = findViewById(R.id.list)
        btn = findViewById(R.id.btn_click)
        val mAdapter = TestAdapter(oldData)
        list.adapter = mAdapter

        btn.setOnClickListener {
            mAdapter.setDatas(newData)
            val diffResult = DiffUtil.calculateDiff(DiffCallBack(oldData, newData), true)
            diffResult.dispatchUpdatesTo(mAdapter)
        }
//        hookOnClickListener(btn)
    }
}