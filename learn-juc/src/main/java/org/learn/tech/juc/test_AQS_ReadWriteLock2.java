package org.learn.tech.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: jimjian
 * Date: 16-3-31 下午2:18
 */
public class test_AQS_ReadWriteLock2 {

    //多个读锁不互斥，读锁与写锁互斥，这是由jvm自己控制。
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(new ReadWriteLockThread1(lock)).start();
        new Thread(new ReadWriteLockThread2(lock)).start();
        new Thread(new ReadWriteLockThread3(lock)).start();
    }

    static class ReadWriteLockThread1 implements Runnable {
        ReadWriteLock lock;

        public ReadWriteLockThread1(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            lock.writeLock().lock();
            System.out.println(" writeLock...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
            System.out.println("Thread WRITELOCK is running!!!");
        }
    }

    static class ReadWriteLockThread2 implements Runnable {
        ReadWriteLock lock;

        public ReadWriteLockThread2(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            lock.readLock().lock();
            System.out.println(" readLock2...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
            System.out.println("Thread READLOCK2 is running!!!");
        }
    }

    static class ReadWriteLockThread3 implements Runnable {
        ReadWriteLock lock;

        public ReadWriteLockThread3(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            lock.readLock().lock();
            System.out.println(" readLock3...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
            System.out.println("Thread READLOCK3 is running!!!");
        }
    }
}