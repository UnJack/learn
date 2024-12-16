package org.learn.tech.juc;

/**
 * Created by jimjian on 2017/2/8.
 *  synchronzied锁重入
 *  happens -before 原理，监视器锁规则
 *  monitorenter
 *  monitorexit
 */
public class test_Synchronized1 {

    public synchronized void method1() {
        System.out.println("method1...");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2...");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3...");
    }

    public static void main(String[] args) {
        final test_Synchronized1 t = new test_Synchronized1();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    t.method1();
                }
            });
            thread.start();
        }
    }
}
