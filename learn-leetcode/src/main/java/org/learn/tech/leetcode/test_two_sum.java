package org.learn.tech.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link 两数之和
 * </br>
 * <a href="https://leetcode.cn/problems/two-sum/description/">
 * https://leetcode.cn/problems/two-sum/description/
 * </a>
 */
public class test_two_sum {

    public static void main(String[] args) {
        int[] nums = {2, 11, 11, 7, 15};
        int target = 9;
        sum0(nums, target);
//        sum1(nums, target);
    }

    public static void sum0(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(map.get(target - nums[i]) + " - " + i);
            }
            map.put(nums[i], i);
        }
    }

    public static void sum1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                System.out.println("l = " + l + ",r = " + r);
                break;
            }
        }
    }
}
