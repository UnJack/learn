package org.learn.tech.design.proxy_customize;

import java.lang.reflect.Method;

/**
 * User: jimjian
 * Date: 16-4-27 下午12:03
 */
public abstract class AfterHandler extends AbstractHandler {

    public abstract void after(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(getTargetObject(), args);
        after(proxy, method, args);
        return result;
    }
}
