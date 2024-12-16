package org.learn.tech.design.singleton_pattern;

/**
 * User: jimjian
 * Date: 16-4-12 下午6:08
 */
public class Singleton {

    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
