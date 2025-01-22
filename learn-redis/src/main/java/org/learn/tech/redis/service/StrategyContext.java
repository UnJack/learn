package org.learn.tech.redis.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StrategyContext {

    public static final ConcurrentHashMap<Integer, Strategy<String, String>> map = new ConcurrentHashMap<>();

    public StrategyContext(List<Strategy<String, String>> list) {
        list.forEach(strategy -> map.put(strategy.getType(), strategy));
    }

    public Strategy<String, String> getStrategy(int type) {
        return map.get(type);
    }
}
