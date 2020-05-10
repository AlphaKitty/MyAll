package com.zyl.common.java.基础.多线程.生产者消费者.lock;

/**
 * 用JUC的Lock类模拟生产者消费者
 */
public class LockTest {
    class Data {
        private int num = 0;

        public void increment() {
            // 资源用完 需要添加
            while (num == 0) {
                // 等待
            }
            num++;

        }
    }
}
