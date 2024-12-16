package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-3-30 下午5:58
 * 线程阻塞中断
 */
public class test_Thread_interrupt {

    //Thread.interrupt()方法不会中断一个正在运行的线程。
    // 它的作用是，在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态。
    public static void main(String[] args) {
        Thread t = new Thread(new InterruptThread());
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();//中断线程
        System.out.println(" end!");
    }

    static class InterruptThread implements Runnable {

        public void run() {
            //检查程序是否发生中断
            //Thread.interrupted(),如果true则说明线程处理中断标识
            while (!Thread.interrupted()) {
                System.out.println("I am running...");
            }
            System.out.println("InterruptThread.run() interrupted!");
        }
    }

}
