package org.learn.tech.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * User: jimjian
 * Date: 16-3-24 上午10:48
 * 适用于一起开始的业务场景：
 * 强调n个线程，大家相互等待，都完成了才继续执行
 * 多线程计算》合并计算的场景
 */
public class test_CyclicBarrier {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();//*!
    }

    public static void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("start test1...");
            }
        });

        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "1号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "2号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "3号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "4号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "5号枪手")));

        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "11号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "22号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "33号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "44号枪手")));
        executorService.execute(new Thread(new CyclicBarrierThread(cyclicBarrier, "55号枪手")));
        executorService.shutdown();

    }

    public static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("start...");
            }
        });
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("  正在执行test2 " + Thread.currentThread().getName());

                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

    public static void test3() {
        CyclicBarrier c = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(" 比赛开始咯");
            }
        });
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(new CyclicBarrierThread(c, String.valueOf(i))).start();
        }
    }

    static class CyclicBarrierThread implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private String name;

        public CyclicBarrierThread() {
        }

        public CyclicBarrierThread(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 正在执行:" + Thread.currentThread().getName() + " " + this.name);

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
