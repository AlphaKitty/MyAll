package com.zyl.util;

/**
 * 打印分割字符串
 */
public class Splitter {

    private static final String DASH_LEFT = "------------------ ";
    private static final String DASH_RIGHT = " ------------------";

    public static void split(String key) {
        System.out.println(DASH_LEFT + key + DASH_RIGHT);
    }
}
