package com.example.floatbutton.mainTest;

/**
 * description:
 *
 * @author zwp
 * @since 2021/12/24
 */
public class staticDemo {

    private static staticDemo demo = new staticDemo();

    public static staticDemo getInstance() {
        return demo;
    }

    public void doFunction(){
        System.out.println("zwp,++++doFunction");
    }
}
