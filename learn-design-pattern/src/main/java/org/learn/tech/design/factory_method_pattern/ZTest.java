package org.learn.tech.design.factory_method_pattern;

/**
 * 工厂方法模式
 */
public class ZTest {

    public static void main(String[] args) {
        Dialog dialog = getDialog("windows");
        assert dialog != null;
        dialog.renderWindow();
    }

    public static Dialog getDialog(String type) {
        if (type.equals("windows")) {
            return new WindowsDialog();
        } else if (type.equals("apple")) {
            return new AppleDialog();
        }
        return null;
    }
}
