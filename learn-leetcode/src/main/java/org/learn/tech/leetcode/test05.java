package org.learn.tech.leetcode;

/**
 * @link 只出现一次的数字
 * </br>
 * <a href="https://leetcode.cn/problems/single-number/">
 * https://leetcode.cn/problems/single-number/
 * </a>
 */
public class test05 {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 2, 1};
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        System.out.println(result);
    }
}
