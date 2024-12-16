package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 15-12-23 下午5:31
 * ++运算是不支持并发的
 * 内存级的重排序会使程序的行为变得不可预测
 */
public class test_Volatile1 {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10; i1++)
                        increase();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}
