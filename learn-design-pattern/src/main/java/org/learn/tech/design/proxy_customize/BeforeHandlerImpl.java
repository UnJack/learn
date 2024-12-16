package org.learn.tech.design.proxy_customize;

import java.lang.reflect.Method;

/**
 * User: jimjian
 * Date: 16-4-27 上午11:40
 */
public class BeforeHandlerImpl extends BeforeHandler {

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("before....");
    }
}
