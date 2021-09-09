package com.example.floatbutton.Service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log

/**
 * description:测试Service的线程
 *
 * @author zwp
 * @since 2021/9/3
 */
class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        Log.v("zwp", "name:" + Thread.currentThread().name + "/id:" + Thread.currentThread().id)
        return LocalBinder()
    }

    override fun onCreate() {
        Log.v("zwp", "name:" + Thread.currentThread().name + "/id:" + Thread.currentThread().id)
        super.onCreate()
    }

    class LocalBinder: Binder() {

    }
}