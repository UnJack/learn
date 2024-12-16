package org.learn.tech.leetcode.common;

import lombok.Data;

/**
 * 树节点
 *
 * @param <T>
 */
@Data
public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.right = right;
    }
}