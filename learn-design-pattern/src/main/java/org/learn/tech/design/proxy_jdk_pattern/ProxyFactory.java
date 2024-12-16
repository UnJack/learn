package org.learn.tech.design.proxy_jdk_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:34
 */
public class ProxyFactory implements InvocationHandler {

    private Class<?> target;

    public Object bind(Class<?> o) {
        this.target = o;
        return Proxy.newProxyInstance(o.getClassLoader(), o.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start...");
        Object result = method.invoke(target.newInstance(), args);
        System.out.println("proxy end...");
        return result;
    }
}
