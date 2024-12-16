package org.learn.tech.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * User: jimjian
 * Date: 16-5-4 下午6:34
 */
public class test_AtomicInteger {
    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);
        System.out.println(atomicStampedReference.compareAndSet(100, 101, 1, 3));
        System.out.println(atomicStampedReference.getStamp());
        int i = 1;
        System.out.println(++i);
        System.out.println(i++);
        System.out.println(i);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("compareAndSet : " + atomicInteger.compareAndSet(0, 1));
        System.out.println("compareAndSet get : " + atomicInteger.get());
        System.out.println("incrementAndGet after : " + atomicInteger.incrementAndGet());
        System.out.println("decrementAndGet after : " + atomicInteger.decrementAndGet());
        // 获取当前的值
        int i1 = atomicInteger.get();
        System.out.println("i1 : " + i1);

        //取当前的值，并设置新的值
        int i2 = atomicInteger.getAndSet(5);
        System.out.println("----------------------------------");
        System.out.println("i2 : " + i2);
        System.out.println("getAndSet after : " + atomicInteger.get());

        // 获取当前的值，并自增
        int i3 = atomicInteger.getAndIncrement();
        System.out.println("----------------------------------");
        System.out.println("i3 : " + i3);
        System.out.println("getAndIncrement after : " + atomicInteger.get());

        // 获取当前的值，并自减
        int i4 = atomicInteger.getAndDecrement();
        System.out.println("----------------------------------");
        System.out.println("i4 : " + i4);
        System.out.println("getAndDecrement after : " + atomicInteger.get());

        // 获取当前的值，并加上预期的值
        int i5 = atomicInteger.getAndAdd(100);
        System.out.println("----------------------------------");
        System.out.println("i5 : " + i5);
        System.out.println("getAndAdd after : " + atomicInteger.get());
    }
}
