package org.learn.tech.design.proxy_customize;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jimjian
 * Date: 16-4-27 上午11:51
 * 动态代理实现aop
 */
public class test_Proxy_customize {
    public static void main(String[] args) {
        BeforeHandlerImpl b = new BeforeHandlerImpl();
        AfterHandlerImpl a = new AfterHandlerImpl();
        List<AbstractHandler> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        Man m = new Man();
        Person p = (Person) ProxyFactory.getProxy(m, list);
        p.eat("a");
    }
}
