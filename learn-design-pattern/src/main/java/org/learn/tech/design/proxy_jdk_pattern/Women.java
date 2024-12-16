package org.learn.tech.design.proxy_jdk_pattern;

/**
 * Created by jimjian on 16/9/6.
 */
public class Women implements Person {
    @Override
    public void eat(String str) {
        System.out.println("Women = " + str);
    }
}
