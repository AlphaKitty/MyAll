package com.zyl.common.java.基础.反射;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

public class ReflectionTest {

    @CallerSensitive
    public static void main(String[] args) {
        ReflectionTest.test();
    }
    @CallerSensitive
    public static void test(){
        System.out.println(Reflection.getCallerClass());
    }
}
