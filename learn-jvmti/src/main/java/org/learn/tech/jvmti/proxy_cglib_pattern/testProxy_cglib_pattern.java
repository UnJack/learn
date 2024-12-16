package org.learn.tech.jvmti.proxy_cglib_pattern;

public class testProxy_cglib_pattern {

    public static void main(String[] args){
        PersonCglib personCglib=new PersonCglib();
        Man man= (Man) personCglib.instance(Man.class);
        man.eat("meituai");
//        man.eat1("meituai");
    }
}
