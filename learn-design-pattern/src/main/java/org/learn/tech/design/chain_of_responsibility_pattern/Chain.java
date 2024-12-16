package org.learn.tech.design.chain_of_responsibility_pattern;

import lombok.Data;

@Data
public abstract class Chain<T, R> {

    private Chain<T, R> next;

    protected Chain<T, R> handle(T t) {
        if (next != null) {
            return next.handle(t);
        }
        return null;
    }
}
