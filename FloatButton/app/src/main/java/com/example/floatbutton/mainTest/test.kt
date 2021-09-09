package com.example.floatbutton.mainTest

import kotlinx.coroutines.*
import org.json.JSONObject
import java.security.MessageDigest
import kotlin.experimental.and

/**
 * description:tt
 *
 * @author zwp
 * @since 2021/2/4
 */
class test : demo() {

    var isHi: State = State()

    override fun setName() {
        super.setName()
    }

    fun sayHi() {
        print(isHi.isA)
    }
}

class State {
    var isA = false
}

//fun main()  = runBlocking<Unit> {
//    val job = launch(Dispatchers.Default){
//        delay(2000)
//        print("launch 执行结束")
//    }
//    delay(1000)
//    job.cancelAndJoin()
//    print("block执行结束")
//}

fun main()  = runBlocking<Unit> {
    val job = launch(Dispatchers.Default){
        var nextPrintTime = System.currentTimeMillis()
        var i = 0
        while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1000)
    job.cancelAndJoin()
    print("block执行结束")

//    GlobalScope.launch {
//
//    }
    coroutineScope {

    }
}