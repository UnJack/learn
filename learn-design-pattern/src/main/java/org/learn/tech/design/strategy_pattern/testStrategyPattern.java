package org.learn.tech.design.strategy_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * User: jimjian
 * Date: 16-3-23 下午3:47
 * 策略模式
 */
public class testStrategyPattern {

    public static void main(String[] args) {
        Map<Integer, LoginStrategy<String>> map = new HashMap<>();
        map.put(0, new StrategyQQLogin());
        map.put(1, new StrategyWeChatLogin());

        map.get(0).handleLogin("1");
    }
}