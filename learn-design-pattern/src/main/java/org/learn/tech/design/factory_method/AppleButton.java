package org.learn.tech.design.factory_method;

public class AppleButton implements Button {

    @Override
    public void render() {
        System.out.println("apple Button");
    }

    @Override
    public void onClick() {
        System.out.println("apple Click! Button says - 'Hello World!'");
    }
}
