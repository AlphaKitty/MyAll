package com.zyl.common.java.基础.多线程.deadlock;

/**
 * 模拟死锁
 * 什么是死锁:
 *      两个好朋友
 *      咬住不松口
 *      为啥不松口
 *      谁松谁是狗
 */
public class DeadLockTest implements Runnable {

    private static boolean flag = true;
    private final String v1 = "1";
    private final String v2 = "2";

    public static void main(String[] args) throws InterruptedException {
        DeadLockTest target = new DeadLockTest();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        // thread1.join();
        // thread2.join();
    }

    private void revert(boolean flag) {
        DeadLockTest.flag = !flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (v1) {
                try {
                    revert(flag);
                    System.out.println(Thread.currentThread() + ": this is v1");
                    Thread.sleep(1000);
                    synchronized (v2) {
                        System.out.println(Thread.currentThread() + ": this is v2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            synchronized (v2) {
                try {
                    revert(flag);
                    System.out.println(Thread.currentThread() + ": this is v2");
                    Thread.sleep(1000);
                    synchronized (v1) {
                        System.out.println(Thread.currentThread() + ": this is v1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
