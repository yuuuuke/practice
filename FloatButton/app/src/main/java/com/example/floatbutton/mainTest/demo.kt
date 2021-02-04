package com.example.floatbutton.mainTest

/**
 * description:dd
 *
 * @author zwp
 * @since 2021/2/4
 */
open class demo {

    var name = ""

    open fun getCLASSName():String{
        return this.javaClass.name
    }

    open fun setName(){
        name = getCLASSName()
    }
}