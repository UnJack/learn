package org.learn.tech.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class test_Atomic {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final test_Atomic test_atomic = new test_Atomic();
        List<Thread> list = new ArrayList(600);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        test_atomic.safeCount();
                        test_atomic.count();
                    }
                }
            });
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(test_atomic.i);
        System.out.println(test_atomic.atomicInteger.get());
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean bool = atomicInteger.compareAndSet(i, ++i);
            if (bool)
                break;
        }
    }

    private void count() {
        i++;
    }
}
