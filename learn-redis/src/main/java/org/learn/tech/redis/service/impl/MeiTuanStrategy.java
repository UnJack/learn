package org.learn.tech.redis.service.impl;

import org.learn.tech.redis.service.Strategy;
import org.springframework.stereotype.Service;

@Service
public class MeiTuanStrategy implements Strategy<String, String> {

    @Override
    public String eat(String food) {
        return "美团" + food;
    }

    @Override
    public int getType() {
        return 1;
    }
}
