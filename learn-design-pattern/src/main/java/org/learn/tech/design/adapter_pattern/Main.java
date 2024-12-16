package org.learn.tech.design.adapter_pattern;

public class Main {
    public static void main(String[] args) {
        eat eat1 = new dog();
        eat1.dinner();
        eat eat2 = new pig();
        eat2.dinner();
        eat eat3 = new peopleAdapter(new people());
        eat3.dinner();
    }
}