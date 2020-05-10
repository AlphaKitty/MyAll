package com.zyl.common.java.基础.多线程.生产者消费者.synchronize;

import java.util.concurrent.TimeUnit;

public class Data {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        // 资源还有 等待消耗
        while (num > 4) {
            wait();
        }
        // 资源耗尽 产出并唤醒消费者
        num++;
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + "产出一个资源,目前资源个数:" + num);
        notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 资源耗尽 等待产出
        while (num == 0) {
            wait();
        }
        // 资源又有了 消耗并唤醒生产者
        num--;
        System.out.println(Thread.currentThread().getName() + "消耗一个资源,目前资源个数:" + num);
        notifyAll();
    }
}
