package com.zyl.common.java.基础.多线程.生产者消费者.synchronize;

public class SynchronizedTest {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            try {
                for (int i = 1; i < 20; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 1; i < 20; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
        new Thread(() -> {
            try {
                for (int i = 1; i < 20; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }

}
