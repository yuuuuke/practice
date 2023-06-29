package com.example.floatbutton.hook

import android.view.View
import android.view.View.OnClickListener
import com.example.floatbutton.LogV
import java.lang.reflect.Field

fun hookOnClickListener(view: View) {
    val getListenerInfo = View::class.java.getMethod("getListenerInfo")
    getListenerInfo.isAccessible = true
    val listenerInfo = getListenerInfo.invoke(view)

    val listenerInfoClz = Class.forName("android.view.View.ListenerInfo")
    val mOnClickListener: Field = listenerInfoClz.getDeclaredField("mOnClickListener")
    mOnClickListener.isAccessible = true
    val myListener = OnClickListenerProxy()
    mOnClickListener.set(listenerInfo, myListener)
}

class OnClickListenerProxy : OnClickListener {

    override fun onClick(v: View?) {
        LogV("打印打印打印")
    }
}