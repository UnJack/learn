package org.learn.tech.design.proxy_cglib_pattern;

/**
 * User: jimjian
 * Date: 16-4-15 下午4:19
 */
public class testProxy_cglib_pattern {

    public static void main(String[] args){
        PersonCglib personCglib=new PersonCglib();
        Man man= (Man) personCglib.instance(Man.class);
        man.eat("Ali");
    }
}
