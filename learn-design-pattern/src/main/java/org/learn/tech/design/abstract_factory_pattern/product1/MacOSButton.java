package org.learn.tech.design.abstract_factory_pattern.product1;

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("MacOSButton");
    }
}
