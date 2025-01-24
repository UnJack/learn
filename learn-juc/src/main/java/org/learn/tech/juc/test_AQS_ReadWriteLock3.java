package org.learn.tech.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: jimjian
 * Date: 16-3-31 下午3:30
 * 读写锁的机制：读-读"不互斥,读-写"互斥,写-写"互斥
 */
public class test_AQS_ReadWriteLock3 {

    private final Map<String, Object> map = new HashMap<>();//缓存器
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        test_AQS_ReadWriteLock3 t = new test_AQS_ReadWriteLock3();
        System.out.println(t.get1("123"));
    }

    // 写锁可以降级为读锁，读锁不可以升级为写锁
    // 线程获取了写锁后，再去获取读锁，然后释放写锁，线程的锁就从写锁降级为了读锁
    public Object get(String id) {
        Object value = null;
        rwl.readLock().lock();//首先开启读锁，从缓存中去取
        try {
            value = map.get(id);
            if (value == null) {
                rwl.readLock().unlock();
                // 获取写锁之前必须释放读锁
                rwl.writeLock().lock();
                if (value == null) value = "abc";
                // 降级通过释放写入锁定之前获取读锁
                rwl.readLock().lock();
                // 解开写锁，仍然保持读
                rwl.writeLock().unlock();
            }
        } finally {
            rwl.readLock().unlock(); //最后释放读锁
        }
        return value;
    }

    public Object get1(String id) {
        Object value = null;
        rwl.writeLock().lock();
        try {
            value = map.get(id);
            if (value == null) {
                rwl.writeLock().unlock();
                // 产生死锁:同一个线程中，在没有释放读锁的情况下，去申请写锁，这属于锁升级，
                // ReentrantReadWriteLock是不支持的。
                rwl.readLock().lock();
                if (value == null)
                    value = "abc";
                // 卡在这里过不了
                rwl.writeLock().lock();
                rwl.readLock().unlock();
            }
        } finally {
            rwl.writeLock().unlock();
        }
        return value;
    }
}
