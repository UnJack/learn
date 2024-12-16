package org.learn.tech.juc.thread_pool;

import java.util.concurrent.*;

/**
 * User: jimjian
 * Date: 16-3-31 下午6:35
 * 适用于：并发稳定的场景
 */
public class test_newFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService fixedThreadPool = new ThreadPoolExecutor(3, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Thread0());
        }
        Thread.sleep(100);
        fixedThreadPool.shutdownNow();//能触发线程中断的机制，优雅的关闭线程池
//        fixedThreadPool.shutdown();//不能出发中断机制，关闭线程池之后，线程依然在执行

    }

    static class Thread0 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000 && !Thread.interrupted(); i++) {
                System.out.println(i + " === " + Thread.currentThread().getName());
            }
        }
    }
}
