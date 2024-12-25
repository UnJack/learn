package org.learn.tech.design.strategy_pattern;

public class StrategyQQLogin implements LoginStrategy<String> {

    @Override
    public int getLoginType() {
        return 0;
    }

    @Override
    public void handleLogin(String request) {
        System.out.println("qq login " + request);
    }
}
