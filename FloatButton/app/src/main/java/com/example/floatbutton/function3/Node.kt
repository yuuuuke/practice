package com.example.floatbutton.function3

/**
 * description:蛛网的节点
 *
 * @author zwp
 * @since 2021/3/17
 */
data class Node(var x: Int, var y: Int, var xSpeed: Int, var ySpeed: Int, var color: Int) {


    init {

        if (xSpeed == 0 ) {
            xSpeed = 1

        }
        if(ySpeed == 0){
            ySpeed = -1
        }
    }
}