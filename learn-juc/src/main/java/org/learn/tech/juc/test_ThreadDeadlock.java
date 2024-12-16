package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-4-28 下午3:47
 * 死锁
 */
public class test_ThreadDeadlock {

    static class SynAddRunnable implements Runnable {

        int a;
        int b;

        SynAddRunnable() {
        }

        SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}
