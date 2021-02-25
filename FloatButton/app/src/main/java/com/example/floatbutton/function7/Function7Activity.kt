package com.example.floatbutton.function7

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floatbutton.R
import kotlinx.android.synthetic.main.layout_function5.*
import kotlinx.android.synthetic.main.layout_function7.*

/**
 * description:分组吸附的头部
 *
 * @author zwp
 * @since 2021/1/28
 */
class Function7Activity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_function7)

        val list = ArrayList<String>()
        list.add("hello world")
        list.add("hello")
        list.add("hello")
        list.add("hello world")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello world")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello world")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        list.add("hello")
        group_rv.adapter = GroupAdapter(list)
        group_rv.layoutManager = LinearLayoutManager(this)

        val groupInfo = ArrayList<GroupBean>()
        groupInfo.add(GroupBean(0, "第一组"))
        groupInfo.add(GroupBean(3, "第二组"))
        groupInfo.add(GroupBean(15, "第三组"))

        group_rv.addItemDecoration(GroupItemDecoration(groupInfo))
    }

}