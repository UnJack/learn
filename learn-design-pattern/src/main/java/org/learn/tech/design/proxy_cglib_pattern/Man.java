package org.learn.tech.design.proxy_cglib_pattern;

/**
 * User: jimjian
 * Date: 16-4-15 下午3:53
 */
public class Man {

    public String eat(String str) {
        String string = "!";
        return "鸭排饭真好吃" + str + string;
    }
}
