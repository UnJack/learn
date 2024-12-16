package org.learn.tech.leetcode;

/**
 * 买卖股票的最佳时机
 * </br>
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 * </a>
 */
public class test09 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num - min > max) {
                max = num - min;
            }
        }
        System.out.println("max = " + max);
    }
}