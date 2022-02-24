package com.example.floatbutton.mainTest

import com.example.floatbutton.LogV
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

fun main() {
    StaticUilts.doReflect()
//    print(StaticUilts.getMD5("android_id=a2b71958134af1eb_android&appkey=4b316a33cd6bd40cabe11f80ec7458f5&authKey=0439b3fae5344ee762d6867bd7ccdc87&chid=6005135&client_id=99bdcdf899aa3f8e_dc2bc6c80cd1f526&imei=&password=c614be&platform=1&sdkVersionNo=1&sdk_appkey=6110ee786f51a_a5e4aede8547ddc7&sdk_version=1.0.1&sdkversion=1.0.1&time=1632379315943&udid=a2b71958134af1eb&username=hw0748f4:60ce5b04505086982790193126dcbf62"));
}


