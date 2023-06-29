package com.example.floatbutton.function13

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.floatbutton.R
import com.example.floatbutton.net.BaseHttpHelper
import com.example.floatbutton.net.DoctorService
import kotlinx.android.synthetic.main.activity_function13.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Flow

/**
 * 分组且带侧边导航的列表
 */
class Function13Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function13)
//        list.layoutManager = CustomLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val mAdapter = DoctorCardAdapter()
        list.adapter = mAdapter

        val service = BaseHttpHelper.create(DoctorService::class.java)

        lifecycleScope.launch {
            val result = service.getHotArticle()
            mAdapter.setData(result.result.datalist)
            list.scrollToPosition(2)
        }
    }
}