package org.learn.tech.design.strategy_pattern;

public class StrategyWeChatLogin implements LoginStrategy<String> {

    @Override
    public int getLoginType() {
        return 1;
    }

    @Override
    public void handleLogin(String request) {
        System.out.println("wechat login " + request);
    }
}
