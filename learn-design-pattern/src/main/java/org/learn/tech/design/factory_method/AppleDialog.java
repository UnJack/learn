package org.learn.tech.design.factory_method;

public class AppleDialog extends Dialog {

    @Override
    Button createButton() {
        return new AppleButton();
    }
}
