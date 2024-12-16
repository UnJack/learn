package org.learn.tech.jvmti.proxy_cglib_pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PersonCglib implements MethodInterceptor {

    public Object instance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("eat")) {
            System.out.println("cglib start");
            System.out.println("proxy class = " + object.getClass().getName());
            System.out.println("method = " + method.getName());
            Object o1 = methodProxy.invokeSuper(object, objects);
            System.out.println("代理执行方法的返回值：" + o1);
            System.out.println("proxy end...");
            return o1;
        } else return null;
    }
}
