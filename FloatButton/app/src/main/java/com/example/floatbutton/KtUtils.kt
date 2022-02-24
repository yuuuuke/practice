package com.example.floatbutton

import android.util.Log

//kt工具类

private const val Tag: String = "zwp"

fun LogV(content: String) {
    if (BuildConfig.DEBUG) {
        Log.v(Tag, content)
    }
}