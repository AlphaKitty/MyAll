package com.zyl.common.java.基础.多线程;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程同步的两种方式
 */
public class ThreadSync implements Runnable {

    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadSync target = new ThreadSync();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("atomicInteger: " + atomicInteger);
        System.out.println("int: " + i);
    }

    public void addAtomicInteger() {
        atomicInteger.getAndIncrement();
    }

    public synchronized void addInteger() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            addAtomicInteger();
            addInteger();
        }
    }
}
