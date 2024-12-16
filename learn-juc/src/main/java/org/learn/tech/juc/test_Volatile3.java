package org.learn.tech.juc;

/**
 * User: jimjian
 * Date 2018/11/17 12:04 PM
 */
public class test_Volatile3 {

    private static boolean ready;
    private static int number;


    public static void main(String[] args) throws InterruptedException {
        new Thread().start();
        number = 42;
        ready = true;
    }

    static class ReadThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
}
