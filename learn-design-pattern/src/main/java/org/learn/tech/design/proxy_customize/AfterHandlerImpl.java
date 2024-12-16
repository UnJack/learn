package org.learn.tech.design.proxy_customize;

import java.lang.reflect.Method;

/**
 * User: jimjian
 * Date: 16-4-27 下午12:04
 */
public class AfterHandlerImpl extends AfterHandler {

    @Override
    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("after...");
    }
}
