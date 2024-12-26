package org.learn.tech.design.abstract_factory_pattern;

import org.learn.tech.design.abstract_factory_pattern.product1.Button;
import org.learn.tech.design.abstract_factory_pattern.product1.WindowsButton;
import org.learn.tech.design.abstract_factory_pattern.product2.CheckBox;
import org.learn.tech.design.abstract_factory_pattern.product2.WindowsCheckBox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
