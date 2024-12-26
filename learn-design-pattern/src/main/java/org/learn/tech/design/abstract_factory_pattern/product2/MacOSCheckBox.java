package org.learn.tech.design.abstract_factory_pattern.product2;

public class MacOSCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("MacOSCheckBox");
    }
}
