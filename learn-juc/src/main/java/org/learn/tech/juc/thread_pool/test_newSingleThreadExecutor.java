package org.learn.tech.juc.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: jimjian
 * Date: 16-5-20 下午10:50
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 适用于：对执行顺序有有要求对场景
 */
public class test_newSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.execute(() -> {
                    System.out.println("创建单个线程来工作，如果发生异常，会创建一个新的线程");
                }
        );
        executorService.shutdown();
    }
}
