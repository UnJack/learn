package org.learn.tech.juc.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * User: jimjian
 * Date: 16-3-31 下午6:33
 * 适用于：执行周期较短的场景，不然内存会被打满
 */
public class test_newCachedThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + index);
                }
            });
        }
        cachedThreadPool.shutdown();
        /**
         * 缓存线程池的队列
         */
//        SynchronousQueue synchronousQueue = new SynchronousQueue();
//        Thread thread = new Thread(() -> {
//            try {
//                synchronousQueue.put("asd");
//                synchronousQueue.put("asd1");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//        Thread.sleep(5000);
//
//        Thread thread1 = new Thread(() -> {
//            try {
//                System.out.println(synchronousQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread1.start();
    }
}
