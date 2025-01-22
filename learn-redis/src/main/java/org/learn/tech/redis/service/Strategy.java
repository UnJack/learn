package org.learn.tech.redis.service;

public interface Strategy<T, R> {
    R eat(T t);

    int getType();
}
