package org.learn.tech.design.proxy_jdk_pattern;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:37
 */
public class test_Proxy_JDK_pattern {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        Person person = (Person) proxyFactory.bind(Man.class);
        person.eat("JD");
        Person person1 = (Person) proxyFactory.bind(Women.class);
        person1.eat("JD");
    }
}
