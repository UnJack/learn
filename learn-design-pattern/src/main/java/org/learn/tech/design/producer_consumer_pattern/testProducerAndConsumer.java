package org.learn.tech.design.producer_consumer_pattern;

import org.learn.tech.design.producer_consumer_pattern.storage2.Storage;

/**
 * User: jimjian
 * Date: 15-12-17 下午3:18
 * 生产者消费者模型
 */
public class testProducerAndConsumer {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String clazz1 = "org.learn.tech.design.producer_consumer_pattern.storage1.Storage";
        String clazz2 = "org.learn.tech.design.producer_consumer_pattern.storage2.Storage";
        String clazz3 = "org.learn.tech.design.producer_consumer_pattern.storage3.Storage";
        // 仓库对象
        StorageInterface storage = (Storage) Class.forName(clazz2).newInstance();
        // 仓库对象

        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
