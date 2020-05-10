package com.zyl.common.java.基础.多线程.threadPool;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayThreadTest implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
