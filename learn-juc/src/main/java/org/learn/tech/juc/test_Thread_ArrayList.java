package org.learn.tech.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jimjian
 * Date: 16-6-14 下午5:09
 */
public class test_Thread_ArrayList {
    static List<Integer> list = new ArrayList<>();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i += 2) {
                list.add(i);
            }
        }
    }

    //ArrayList 在扩容过程中，内部一致性被破坏，但由于没有锁的保护，
    // 另外一个线程访问到了不一致的内部状态，导致出现越界问题。
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
