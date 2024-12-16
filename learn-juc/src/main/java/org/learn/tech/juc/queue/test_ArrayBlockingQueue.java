package org.learn.tech.juc.queue;

/**
 * Created by jimjian on 2020-01-01.
 */
public class test_ArrayBlockingQueue {
    public static void main(String[] args) {
        addWorker();
    }

    private static void addWorker() {
        int i = 0;
        retry:
        for (; ; ) {
            if (i == 50) {
                continue retry;
            }
            if (i == 88) {
                System.out.println("break = " + i);
                break retry;
            }
            i++;
            System.out.println("i = " + i);
        }
    }
}
