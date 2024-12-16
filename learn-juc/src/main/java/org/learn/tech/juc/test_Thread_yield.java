package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-7-28 上午10:24
 */
public class test_Thread_yield implements Runnable {

    protected static int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public test_Thread_yield() {
    }

    public test_Thread_yield(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // 将CPU从一个线程转移给另一个线程
            //1.调用此方法可以将线程状态从运行状态到可运行状态,2.cpu时间片用完
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        new Thread(new test_Thread_yield()).start();
        new Thread(new test_Thread_yield()).start();
    }
}
