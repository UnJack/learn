package org.learn.tech.design.proxy_customize;

import java.lang.reflect.InvocationHandler;
/**
 * User: jimjian
 * Date: 16-4-27 上午11:36
 * 自定义AOP
 */
public abstract class AbstractHandler implements InvocationHandler {

    private Object targetObject;

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject() {
        return targetObject;
    }
}
