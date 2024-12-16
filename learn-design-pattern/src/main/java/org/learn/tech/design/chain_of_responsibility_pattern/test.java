package org.learn.tech.design.chain_of_responsibility_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */
public class test {
    public static void main(String[] args) {
        Chain<String, String> chain1 = new Chain1();
        Chain<String, String> chain2 = new Chain2();
        chain1.setNext(chain2);
        chain1.handle("1");

        List<Chain<String, String>> list = new ArrayList<>();
        list.add(new Chain1());
        list.add(new Chain2());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNext(list.get(i + 1));
        }
    }
}
