package org.learn.tech.design.chain_of_responsibility_pattern;

public class Chain1 extends Chain<String, String> {

    @Override
    protected Chain<String, String> handle(String s) {
        System.out.println("chain1");
        return super.handle(s);
    }
}
