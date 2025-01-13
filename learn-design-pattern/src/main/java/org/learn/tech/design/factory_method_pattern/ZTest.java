package org.learn.tech.design.factory_method_pattern;

/**
 * 工厂方法模式</br>
 * 以下是来自核心 Java 程序库的一些示例：</br>
 * {@link java.util.Calendar#getInstance()}</br>
 * {@link java.text.NumberFormat#getInstance()}</br>
 * {@link java.net.URLStreamHandlerFactory#createURLStreamHandler(String)}</br>
 * {@link java.util.EnumSet#of(Enum)}</br>
 * {@link java.nio.charset.Charset#forName(String)}
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
