package org.learn.tech.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * User: jimjian
 * Date: 16-3-24 上午10:24
 * 适用于等待结束的业务场景：
 * 一个线程等待另外n个线程完成某件事后才继续执行
 */
public class test_AQS_CountDownLatch1 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(10);
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(i, doneSignal, startSignal)).start();
        }
        startSignal.countDown();
        doneSignal.await();
        System.out.println(" 百米大战开始...");
    }

    static class Worker implements Runnable {
        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;
        private int i;

        Worker(int i, CountDownLatch doneSignal, CountDownLatch startSignal) {
            this.i = i;
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                Thread.sleep(new Random().nextInt(10000));
                System.out.println(i + " 号选手准备就绪");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                doneSignal.countDown();
            }
        }
    }
}


