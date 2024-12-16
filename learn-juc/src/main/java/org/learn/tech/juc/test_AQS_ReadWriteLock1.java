package org.learn.tech.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: jimjian
 * Date: 16-3-31 下午3:03
 * 适用于高度取频率，低写入频率的业务常见
 */
public class test_AQS_ReadWriteLock1 {

    public static void main(String[] args) {
        final ReadWriteLockMap lockMap = new ReadWriteLockMap();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    lockMap.get();
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    lockMap.put(finalI);
                }
            }).start();
        }
    }

    static class ReadWriteLockMap {
        private Object data = null;
        private ReadWriteLock rw = new ReentrantReadWriteLock();
        private Lock readLock = rw.readLock();
        private Lock writeLock = rw.writeLock();

        public void get() {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 准备读取数据!");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "有读数据 :" + data);
            readLock.unlock();
        }

        public void put(Object data) {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 准备写取数据!");
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " 有写数据: " + data);
            writeLock.unlock();
        }
    }
}
