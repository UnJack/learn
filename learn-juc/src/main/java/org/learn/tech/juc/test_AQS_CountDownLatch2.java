package org.learn.tech.juc;

import java.util.concurrent.CountDownLatch;

/**
 * User: jimjian
 * Date: 16-7-7 下午4:11
 */
public class test_AQS_CountDownLatch2 {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    static class CountDownLatchThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("CountDownLatchThread_1 $start"+ Thread.currentThread().getName());
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CountDownLatchThread_1 $end"+ Thread.currentThread().getName());
        }
    }

    static class CountDownLatchThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("CountDownLatchThread_2 $" + Thread.currentThread().getName());
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new Thread(new CountDownLatchThread1()).start();
        new Thread(new CountDownLatchThread2()).start();
        new Thread(new CountDownLatchThread2()).start();
    }
}
