package com.zyl.common.spring.异步任务;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.UUID;

import static java.lang.Thread.sleep;

@Controller
@RequestMapping("async")
public class AsyncManagerController {
    @Qualifier("threadPoolTaskExecutor")
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 开启一个异步线程 用于处理一些耗时操作 在超时时间范围内返回或提示超时
     *
     * @return 需要返回WebAsyncTask实现 用来注册到AsyncManager中 否则异步线程不会执行
     */
    @GetMapping("task")
    public WebAsyncTask<String> asyncTask() {
        // 打印处理线程名
        System.out.println("请求处理线程：" + Thread.currentThread().getName());

        // 模拟开启一个异步任务，超时时间为10s 如果超时时间内没有完成异步任务 会抛出一个AsyncRequestTimeoutException警告
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            System.out.println("异步工作线程：" + Thread.currentThread().getName());
            // 任务处理时间5s，不超时
            sleep(5 * 1000L);
            // int a = 1 / 0;
            return UUID.randomUUID().toString();
        });

        // 任务执行完成时调用该方法
        asyncTask.onCompletion(() -> System.out.println("任务执行完成"));
        // 任务执行出错时调用该方法
        asyncTask.onError(() -> {
            System.out.println("函数式接口的实现");
            return "发生错误后函数式接口的返回值";
        });
        // 任务执行超时时调用该方法
        asyncTask.onTimeout(() -> {
            System.out.println("异步任务超时");
            return "超时后函数式接口的返回值";
        });
        System.out.println("继续处理其他事情");
        return asyncTask;
    }

    /**
     * 如果一段时间内异步线程开启个数过多 会对系统柜性能造成影响
     * 可以启用线程池管理异步线程 也是一种削峰思想
     *
     * @return 和异步线程一样 都需要返回WebAsyncTask实现
     */
    @GetMapping("tpTask")
    public WebAsyncTask<String> threadPoolAsyncTask() {
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, threadPoolTaskExecutor, () -> {
            System.out.println("异步线程池: " + Thread.currentThread().getName());
            sleep(5 * 1000L);
            return "";
        });
        asyncTask.onCompletion(() -> System.out.println("线程池任务执行成功"));
        asyncTask.onError(() -> {
            System.out.println("线程池任务执行失败");
            return "error";
        });
        asyncTask.onTimeout(() -> {
            System.out.println("线程池任务执行超时");
            return "timeout";
        });
        return asyncTask;
    }
}
