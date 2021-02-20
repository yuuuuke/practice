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
    val par = test()
    var hi = State()
    hi.isA = false
    par.isHi = hi
    hi.isA = true
    par.sayHi()
}