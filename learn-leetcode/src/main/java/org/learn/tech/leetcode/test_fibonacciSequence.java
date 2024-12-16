package org.learn.tech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimjian on 2020-03-15.
 * 斐波那契
 */
public class test_fibonacciSequence {

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.print(fibonacci1(i) + " ");
        }
    }

    /**
     * 递归
     *
     * @param num
     * @return
     */
    public static int fibonacci1(int num) {
        if (num < 0) {
            return -1;
        }
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci1(num - 1) + fibonacci1(num - 2);
    }

    /**
     * 非递归
     *
     * @param num
     * @return
     */
    public static List<Integer> fibonacci2(int num) {
        if (num < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        for (int i = 2; i < num; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list;
    }
}
