package com.zyl.common.java.lang;

public class StringBuilderTest {
    public static void main(String[] args) {
        new StringBuilderTest().resetSpeed(new StringBuilder());
    }

    /**
     * StringBuilder没有提供原生的重置内容方法
     * 比较三种不同的重置方法耗时区分优劣
     * 分别是 new/delete/setLength
     * 注意三种方法append的字符串不能相同 排除干扰 具体什么干扰后面研究
     *
     * 最终得出setLength是最好的
     */
    public void resetSpeed(StringBuilder builder) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            builder.append(123123);
        }
        builder = new StringBuilder();
        long end = System.currentTimeMillis();
        System.out.println("new执行成功 耗时:" + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            builder.append(456456);
        }
        builder.delete(0, builder.length());
        long end1 = System.currentTimeMillis();
        System.out.println("delete执行成功 耗时:" + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            builder.append(789789);
        }
        builder.setLength(0);
        long end2 = System.currentTimeMillis();
        System.out.println("setLength执行成功 耗时:" + (end2 - start2) + "ms");
    }
}
