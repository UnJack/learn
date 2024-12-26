package org.learn.tech.design.factory_method;

public class WindowButton implements Button {

    @Override
    public void render() {
        System.out.println("windows Button");
    }

    @Override
    public void onClick() {
        System.out.println("windows Click! Button says - 'Hello World!'");
    }
}
