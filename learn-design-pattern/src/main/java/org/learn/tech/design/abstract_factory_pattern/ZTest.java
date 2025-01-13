package org.learn.tech.design.abstract_factory_pattern;

import org.learn.tech.design.abstract_factory_pattern.product1.Button;

/**
 * 抽象工厂模式</br>
 * 以下是来自核心 Java 程序库的一些示例：</br>
 * {@link javax.xml.parsers.DocumentBuilderFactory#newInstance()}</br>
 * {@link javax.xml.transform.TransformerFactory#newInstance()}</br>
 * {@link javax.xml.xpath.XPathFactory#newInstance()}</br>
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
