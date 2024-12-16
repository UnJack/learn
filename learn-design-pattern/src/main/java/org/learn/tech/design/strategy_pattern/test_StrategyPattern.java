package org.learn.tech.design.strategy_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * User: jimjian
 * Date: 16-3-23 下午3:47
 * 策略模式
 */
public class test_StrategyPattern {

    public static void main(String[] args) {
        LoginHandler<String> loginHandler = new QQLoginHandler();
        LoginHandler<String> loginHandler1 = new WeChatLoginHandler();
        loginHandler.handleLogin("1");
        loginHandler1.handleLogin("2");

        Map<Integer, LoginHandler<String>> map = new HashMap<>();
        map.put(1, new QQLoginHandler());
    }
}