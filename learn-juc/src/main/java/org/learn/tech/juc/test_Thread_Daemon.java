package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-6-13 下午6:47
 * 守护进程demo
 */
public class test_Thread_Daemon {

    public static class ThreadDaemon extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadDaemon();
        // 设置守护进程
        t.setDaemon(true);
        t.start();

        Thread.sleep(9000);
    }
}

