package com.example.floatbutton.function11

import androidx.recyclerview.widget.DiffUtil
import com.example.floatbutton.LogV

/**
 * description:核心类 用来判断 新旧Item是否相等
 *
 * @author zwp
 * @since 2021/9/15
 */
class DiffCallBack(private val lastData: ArrayList<TestBean>, private val newData: ArrayList<TestBean>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return lastData.size
    }

    override fun getNewListSize(): Int {
        return newData.size
    }

    /**
     * 用来判断是否是同一个item
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        LogV("oldItemPosition = $oldItemPosition , newItemPosition = $newItemPosition")
        return lastData[oldItemPosition].name == newData[newItemPosition].name
    }

    /**
     * 只有 areItemsTheSame 为 True的时候才会调用这个方法
     * 用来判断是否UI需要改变
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        LogV("////oldItemPosition = $oldItemPosition , newItemPosition = $newItemPosition")
        return lastData[oldItemPosition] == newData[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}