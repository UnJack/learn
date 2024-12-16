package org.learn.tech.jvmti.proxy_jdk_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    private Class target;

    public Object bind(Class o) {
        this.target = o;
        return Proxy.newProxyInstance(o.getClassLoader(), o.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start...");
        System.out.println("method = "+method.getName());
        System.out.println("args = "+args);
        Object result = method.invoke(target.newInstance(), args);
        System.out.println("proxy class = " + target.newInstance().getClass().getName());
        System.out.println("proxy end...");
        return result;
    }
}