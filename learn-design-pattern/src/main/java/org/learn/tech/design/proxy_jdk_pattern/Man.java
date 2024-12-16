package org.learn.tech.design.proxy_jdk_pattern;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:33
 */
public class Man implements Person {
    @Override
    public void eat(String str) {
        System.out.println("Man = " + str);
    }
}
