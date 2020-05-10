package com.zyl.common.java.基础.Lambda.generic;

public class LambdaTest<T> {
    public static void main(String[] args) {
        LambdaTest<String> lambdaTest = new LambdaTest<>();
        // Lambda表达式里的返回不返回到宿主方法 而是返回到Lambda表达式接口 对此返回值的后续操作在函数式接口宿主方法实现里
        lambdaTest.lam(() -> {
            System.out.println("234");
            return "666";
        });
    }

    /**
     * 函数式接口泛型是调用方提供的
     *
     * @param func 函数式接口
     */
    public void lam(FuncInterface<T> func) {
        T t = func.doSomething();
        System.out.println(t);
    }
}
