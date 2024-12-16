package org.learn.tech.design.producer_consumer_pattern;

/**
 * User: jimjian
 * Date: 16-3-22 下午5:43
 */
public interface StorageInterface {

    public void produce(int num);
    public void consume(int num);
}

