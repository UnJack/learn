package org.learn.tech.design.abstract_factory_pattern;

import org.learn.tech.design.abstract_factory_pattern.product1.Button;

/**
 * Created by jimjian on 2017/3/15.
 */
public class ZTest {
    public static void main(String[] args) {
        GUIFactory guiFactory = new MacOSFactory();
        Button button = guiFactory.createButton();
        button.paint();

        GUIFactory guiFactory1 = new WindowsFactory();
        guiFactory1.createCheckBox().paint();
    }
}
