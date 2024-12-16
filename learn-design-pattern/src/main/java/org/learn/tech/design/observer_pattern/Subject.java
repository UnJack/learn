package org.learn.tech.design.observer_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 上午11:48
 */
public interface Subject {

    void postNewJob(String job);

    void registerUser(Observer observer);

    void notifyAllUser(String str);
}
