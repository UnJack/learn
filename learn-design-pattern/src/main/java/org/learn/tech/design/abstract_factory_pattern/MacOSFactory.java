package org.learn.tech.design.abstract_factory_pattern;

import org.learn.tech.design.abstract_factory_pattern.product1.Button;
import org.learn.tech.design.abstract_factory_pattern.product1.MacOSButton;
import org.learn.tech.design.abstract_factory_pattern.product2.CheckBox;
import org.learn.tech.design.abstract_factory_pattern.product2.MacOSCheckBox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
