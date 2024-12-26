package org.learn.tech.design.abstract_factory_pattern;

import org.learn.tech.design.abstract_factory_pattern.product1.Button;
import org.learn.tech.design.abstract_factory_pattern.product2.CheckBox;

public interface GUIFactory {

    default Button createButton() {
        return null;
    }

    default CheckBox createCheckBox() {
        return null;
    }
}
