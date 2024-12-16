package org.learn.tech.jvmti.proxy_jdk_pattern;

public class test_Proxy_JDK_pattern {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
//        Person person = (Person) proxyFactory.bind(Man.class);
//        person.eat("meituan");
        Person person1 = (Person) proxyFactory.bind(Women.class);
        person1.eat("JD");
    }
}
