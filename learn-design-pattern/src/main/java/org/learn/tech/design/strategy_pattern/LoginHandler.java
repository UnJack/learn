package org.learn.tech.design.strategy_pattern;

import java.io.Serializable;

public interface LoginHandler<T extends Serializable> {

    /**
     * 获取登录类型
     *
     * @return
     */
    int getLoginType();

    /**
     * 登录
     *
     * @param request
     * @return
     */
    void handleLogin(String request);
}
