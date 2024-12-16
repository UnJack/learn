package org.learn.tech.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: jimjian
 * Date: 15-12-18 Time: 下午1:10
 * http://www.cnblogs.com/maypattis/p/6403682.html
 * https://segmentfault.com/a/1190000008471362
 */
public class test_AQS_ReentrantLock_Condition {

    public static void main(String[] args) {
        myThread m = new myThread();
        Thread thread = new Thread(m);
        thread.start();
        System.out.println("主线程：" + thread.getName());
    }

    static class myThread implements Runnable {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        int j = 0;

        public void say1() throws InterruptedException {
            lock.lock();
            while (j != 0)
                c1.await();
            System.out.println("AAA111 - " + Thread.currentThread().getName());
            j = (j + 1) % 3;
            c2.signal();
            lock.unlock();
        }

        public void say2() throws InterruptedException {
            lock.lock();
            while (j != 1)
                c2.await();
            System.out.println("BBB222 - " + Thread.currentThread().getName());
            j = (j + 1) % 3;
            c3.signal();
            lock.unlock();
        }

        public void say3() throws InterruptedException {
            lock.lock();
            while (j != 2)
                c3.await();
            System.out.println("CCC333 - " + Thread.currentThread().getName());
            j = (j + 1) % 3;
            c1.signal();
            lock.unlock();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    say1();
                    say2();
                    say3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




