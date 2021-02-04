package com.example.floatbutton.mainTest

/**
 * description:tt
 *
 * @author zwp
 * @since 2021/2/4
 */
class test : demo() {

    override fun setName() {
        super.setName()
    }

}

fun main() {
    val par = test()
    par.setName()
    print(par.name)
}