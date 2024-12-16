package org.learn.tech.design.adapter_pattern;

public class dog implements eat {
    @Override
    public void dinner() {
        System.out.println("dog eat");
    }
}
