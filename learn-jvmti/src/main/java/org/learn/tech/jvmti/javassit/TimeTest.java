package org.learn.tech.jvmti.javassit;

public class TimeTest {

    public static void main(String[] args) {
        boy();
        girl("hello world222222222");
    }

    public static void boy() {
        try {
            Thread.sleep(2000);
            System.out.println("hello world!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void girl(String hello) {
        try {
            Thread.sleep(1000);
            System.out.println(hello);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}