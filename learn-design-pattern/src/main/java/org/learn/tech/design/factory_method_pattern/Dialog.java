package org.learn.tech.design.factory_method_pattern;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
        okButton.onClick();
    }

    abstract Button createButton();
}
