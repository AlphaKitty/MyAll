package com.zyl.util;

/**
 * 标准字符串打印工具类
 */
public class StringAppender {

    public static final StringBuilder result = new StringBuilder();

    public static String append(byte[] bytes) {
        result.setLength(0);
        for (int aByte : bytes) {
            result.append((char) aByte);
        }
        return result.toString();
    }

    public static String append(String name, byte[] bytes) {
        return name + ": " + append(bytes);
    }

    public static String append(String name, Object object) {
        return name + ": " + object;
    }

}
