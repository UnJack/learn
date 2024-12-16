package org.learn.tech.design.producer_consumer_pattern;

import org.learn.tech.design.producer_consumer_pattern.storage2.Storage;

/**
 * Created with IntelliJ IDEA.
 * User: jimjian
 * Date: 15-12-17
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class Consumer extends Thread {

    private StorageInterface storage;

    //每次消费的数量
    private int num;

    public Consumer() {
    }

    public Consumer(StorageInterface storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num) {
        storage.consume(num);
    }

    public StorageInterface getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

