package org.learn.tech.leetcode;

/**
 * @link 最大子序和
 * </br>
 * <a href="https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/">
 * https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
 * </a>
 */
public class test_max_sub_array {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = 0;
        int sum = nums[0];
        for (int i : nums) {
            max = Math.max(i, max + i);
            sum = Math.max(max, sum);
        }
        System.out.println(sum);
    }
}
