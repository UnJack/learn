package org.learn.tech.design.proxy_cglib_pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:53
 * cglib代理
 * CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，
 * 但是CGLib在创建代理对象时所花费的时间却比JDK多得多，
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，反之，使用JDK方式要更为合适一些。
 * 同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理。
 */
public class PersonCglib implements MethodInterceptor {

    public Object instance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy start...");
        Object o1 = methodProxy.invokeSuper(object, objects);
        System.out.println("proxy class = " + object.getClass().getName());
        System.out.println("proxy end...");
        return o1;
    }
}
