package com.example.floatbutton

/**
 * description:功能类
 *
 * @author zwp
 * @since 2021/1/26
 */
data class FunctionBean(val desc:String,
                        val onClick:() -> Unit
                        )