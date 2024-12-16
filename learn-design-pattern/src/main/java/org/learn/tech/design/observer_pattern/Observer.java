package org.learn.tech.design.observer_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 上午11:52
 */
public interface Observer {
    void notifyMessage(Subject subject, String str);
}
