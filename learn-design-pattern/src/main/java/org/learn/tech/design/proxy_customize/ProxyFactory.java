package org.learn.tech.design.proxy_customize;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * User: jimjian
 * Date: 16-4-27 上午11:42
 */
public class ProxyFactory {

    public static Object getProxy(Object object, List<AbstractHandler> list) {
        Object proxyObject = null;
        if (list.size() > 0) {
            proxyObject = object;
            for (AbstractHandler abstractHandler : list) {
                abstractHandler.setTargetObject(proxyObject);
                proxyObject = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), abstractHandler);
            }
            return proxyObject;
        } else {
            return object;
        }
    }
}
