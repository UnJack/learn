package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-3-31 上午11:56
 */
public class test_Thread_activeCount {

    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        t.setName("Admin Thread");
        // set thread priority to 1
        t.setPriority(2);

        // prints the current thread
        System.out.println("Thread = " + t);

        int count = Thread.activeCount();
        System.out.println("currently active threads = " + count);

        Thread th[] = new Thread[count];
        // returns the number of threads put into the array
        Thread.enumerate(th);

        // prints active threads
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + th[i]);
        }
    }
}
