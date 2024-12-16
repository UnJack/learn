package org.learn.tech.design.chain_of_responsibility_pattern;

public class Chain2 extends Chain<String, String> {

    @Override
    protected Chain<String, String> handle(String s) {
        System.out.println("chain2");
        return super.handle(s);
    }
}
