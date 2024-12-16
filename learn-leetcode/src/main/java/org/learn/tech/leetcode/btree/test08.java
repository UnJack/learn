package org.learn.tech.leetcode.btree;

import org.learn.tech.leetcode.common.TreeNode;

/**
 * @link 将有序数组转换为二叉搜索树
 * </br>
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/">
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 * </a>
 */
public class test08 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode<Integer> root = tri(nums, 0, nums.length - 1);
    }

    public static TreeNode<Integer> tri(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode<Integer> root = new TreeNode<>(nums[mid]);
        root.setLeft(tri(nums, left, mid - 1));
        root.setRight(tri(nums, mid + 1, right));
        return root;
    }
}
