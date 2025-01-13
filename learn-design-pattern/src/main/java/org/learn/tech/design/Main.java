package org.learn.tech.design;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal.get();
        Calendar calendar = Calendar.getInstance();
    }
}