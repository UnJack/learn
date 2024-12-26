package org.learn.tech.design.factory_method;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    abstract Button createButton();
}
