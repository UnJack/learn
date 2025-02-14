package org.learn.tech.leetcode;

/**
 * @link 盛最多水的容器
 * </br>
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/">
 * https://leetcode.cn/problems/container-with-most-water/description/
 * </a>
 */
public class test_max_water_area {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWaterArea(nums));
    }

    public static int maxWaterArea(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(nums[l], nums[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (nums[l] < nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
