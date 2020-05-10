package com.zyl.common.java.基础.参数和引用;

import java.util.Arrays;

public class ReferenceTest {
    
    public void changeInt(int a){
        a = 5;
    }

    // String字符串做参数时(无论字符串的初始化是直接赋值还是堆对象) 对值的修改不会改变该参数 因为传入的是字符串副本(String本身是final的) 内容是不会变的
    public void changeStr(String value) {
        value = value + 1;
    }

    // StringBuilder是对象 做参数时传入的就是本身 对象本身的内容可以改变 但是不return出去的话 对象的指向是不会变的
    public void changeStrBldr(StringBuilder value) {
        value.append("1");
        value = new StringBuilder("111");
    }

    public static void main(String[] args) {
        ReferenceTest localReferenceTest = new ReferenceTest();

        String slot1 = "123";
        String slot2 = new String("456");
        localReferenceTest.changeStr(slot1);
        localReferenceTest.changeStr(slot2);
        System.out.println(slot1);
        System.out.println(slot2);

        StringBuilder builder = new StringBuilder("123");
        localReferenceTest.changeStrBldr(builder);
        System.out.println(builder);
        
        int a = 1;
        localReferenceTest.changeInt(a);
        System.out.println(a);

        String[] aaa = new String[]{"11", "22", "33"};
        String[] aaaa = null;
        System.out.println(Arrays.equals(aaaa, aaaa));
    }
}
