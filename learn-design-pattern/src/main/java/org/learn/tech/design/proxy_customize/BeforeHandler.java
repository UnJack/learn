package org.learn.tech.design.proxy_customize;

import java.lang.reflect.Method;

/**
 * User: jimjian
 * Date: 16-4-27 上午11:37
 */
public abstract class BeforeHandler extends AbstractHandler {

    public abstract void before(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy, method, args);
        return method.invoke(getTargetObject(), args);
    }
}
