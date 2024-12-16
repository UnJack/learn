package org.learn.tech.design.proxy_customize;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:33
 */
public class Man implements Person {
    @Override
    public String eat(String str) {
        System.out.println("真在吃鸡腿饭..." + str);
        return "真在吃鸡腿饭..." + str;
    }
}
