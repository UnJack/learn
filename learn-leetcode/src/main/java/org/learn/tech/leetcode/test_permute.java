package org.learn.tech.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @link 全排列
 * </br>
 * <a href="https://leetcode.cn/problems/permutations/description/">
 * https://leetcode.cn/problems/permutations/description/
 * </a>
 */
public class test_permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(res, output, nums.length, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> output, int length, int first) {
        // 所有数都填完了
        if (first == length) {
            res.add(output);
        }
        for (int i = first; i < length; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(res, output, length, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
