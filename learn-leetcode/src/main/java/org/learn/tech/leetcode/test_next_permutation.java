package org.learn.tech.leetcode;

import java.util.Arrays;

/**
 * @link 下一个排列
 * </br>
 * <a href="https://leetcode.cn/problems/next-permutation/">
 * https://leetcode.cn/problems/next-permutation/
 * </a>
 */
public class test_next_permutation {

    public static void main(String[] args) {
        int[] p = {1, 2, 3};
        nextPermutation(p);
        System.out.println(Arrays.toString(p));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
