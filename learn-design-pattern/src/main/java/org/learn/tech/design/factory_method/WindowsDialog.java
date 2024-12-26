package org.learn.tech.design.factory_method;

public class WindowsDialog extends Dialog {

    @Override
    Button createButton() {
        return new WindowButton();
    }
}
