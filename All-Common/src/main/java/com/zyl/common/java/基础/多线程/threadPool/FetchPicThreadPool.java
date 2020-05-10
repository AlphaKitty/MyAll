package com.zyl.common.java.基础.多线程.threadPool;

import java.util.concurrent.*;

/**
 * 新线程的安排顺序: 核心线程 -> Queue -> 非核心线程 -> 抛出RejectedExecutionException
 * ThreadPoolExecutor的7个入参决定线程池模型 而Queue的实现子类类型决定队列策略 包括队列长度,甩线程给非核心时机,执行延时等
 * Executors的几种现成的线程池其实是对ThreadPoolExecutor的几种常用封装 满足大多数情况 实际使用最好还是根据实际需要自己用ThreadPoolExecutor实现
 */
public class FetchPicThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 所有的新线程都直接交给线程池处理 所以用这种Queue的时候maximumPoolSize一般设置为Integer.MAX_VALUE 否则很容易抛RejectedExecutionException
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<>();
        // 不设置队列最大长度的Queue 所有大于核心线程数的新线程都会先被安排到Queue中 因为Queue的顺序先于maximumPoolSize的限制 所以永远不会抛出RejectedExecutionException异常 线程池中执行的最大线程总是核心线程数
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        // 可以设置队列长度的Queue 如果达到了核心线程数目 新线程入等待队列 如果等待队列满了 起新的非核心线程 如果非核心线程也满了 抛出RejectedExecutionException
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(20);
        // 泛型必须实现Delayed接口 经过设定的延时之后才会从Queue中出队 然后被线程池处理
        DelayQueue<DelayThreadTest> delayQueue = new DelayQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.SECONDS, linkedBlockingQueue);
        for (int i = 0; i < 100; i++) {
            // target放在循环内时 对i++这种的操作需要在Class层面上加锁 而对AtomicInteger这种的没有影响
            ThreadTest target = new ThreadTest();
            Runnable thread = new Thread(target);
            threadPoolExecutor.execute(thread);
            // System.out.println(threadPoolExecutor.getTaskCount());
        }
        threadPoolExecutor.shutdown();
        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                // System.out.println(ThreadTest.integer);
                System.out.println(ThreadTest.i);
                break;
            }
        }
        // 最大线程池线程数为核心线程数的队列无上限线程池 同时执行的线程数为核心线程数也就是最大线程数
        Executors.newFixedThreadPool(10);
        // 等同于设置了Integer.MAX_VALUE的SynchronousQueue 无最大线程数限制 和原生多线程比作用仅仅是增加了线程复用 同时执行的线程数可认为无上限
        Executors.newCachedThreadPool();
        // 线程池最大线程数无上限 和CashedThreadPool类似 但启用了默认延时 不会无脑执行线程
        Executors.newScheduledThreadPool(10);
        // 核心和最大线程池线程都只有一个 线程会按照给定的线程集合顺序执行 同时执行的线程数为1
        Executors.newSingleThreadExecutor();
    }
}
