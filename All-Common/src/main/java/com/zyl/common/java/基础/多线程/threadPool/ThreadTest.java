package com.zyl.common.java.基础.多线程.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest implements Runnable {
    public static int i = 0;
    public static AtomicInteger integer = new AtomicInteger(0);
    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
             add();
//            addSync();
        }
    }
    public synchronized void add(){
        i++;
    }
    public void addSync(){
        integer.incrementAndGet();
    }
}
