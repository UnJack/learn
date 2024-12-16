package org.learn.tech.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: jimjian
 * Date: 16-3-25 下午5:34
 * 详细介绍:http://blog.csdn.net/coslay/article/details/45176063
 * “公平信号量”和”非公平信号量”的释放信号量的机制是一样的！
 * 不同的是它们获取信号量的机制：线程在尝试获取信号量许可时，
 * 对于公平信号量而言，如果当前线程不在CLH队列的头部，则排队等候；
 * 而对于非公平信号量而言，无论当前线程是不是在CLH队列的头部，它都会直接获取信号量。
 * 该差异具体的体现在，它们的tryAcquireShared()函数的实现不同。
 * 信号量:1.公平信号量，2非公平信号量
 * 默认是非公平信号量
 * <p>
 * 一般用于控制同时访问特定资源的线程数量
 * 并发上限流量控制
 */
public class test_AQS_Semaphore {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    //获取信号
                    semaphore.acquire();
                    System.out.println(finalI);
                    Thread.sleep(2000);
                    //释放信号
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            service.execute(thread);
        }
        service.shutdown();
    }
}
