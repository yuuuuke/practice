package com.example.floatbutton.mainTest

/**
 * description:tt
 *
 * @author zwp
 * @since 2021/2/4
 */
class test : demo() {

    var isHi:State = State()

    override fun setName() {
        super.setName()
    }

    fun sayHi(){
       print(isHi.isA)
    }
}

class State{
    var isA = false
}

fun main() {
//    val par = test()
//    var hi = State()
//    hi.isA = false
//    par.isHi = hi
//    hi.isA = true
//    par.sayHi()

    try{
//        var a:String? = null
//        a!!.length
        throw Exception()
    }catch (e:Exception){
        System.out.println("hello1")
        return
    }finally {
        System.out.println("hello2")
    }
}