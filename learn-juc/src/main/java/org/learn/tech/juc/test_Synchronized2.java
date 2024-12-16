package org.learn.tech.juc;

/**
 * Created by jimjian on 2017/2/8.
 */
public class test_Synchronized2 {

    public static void main(String[] args){
        new Thread(new SynchronizedThread()).start();
    }

    static class SynchronizedThread implements Runnable{

        @Override
        public void run() {
            synchronized (test_Synchronized2.class){
                System.out.println("test_Synchronized2");
            }
        }
    }
}
