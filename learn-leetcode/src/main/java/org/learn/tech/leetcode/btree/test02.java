package org.learn.tech.leetcode.btree;

import org.learn.tech.leetcode.common.TreeNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @link 中序遍历，左根右
 * </br>
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 * </a>
 */
public class test02 {
    public static void main(String[] args) {
//                   1
//              11      12
//           13    14  15   16
        TreeNode<Integer> root = TreeNodeFactory.getTreeNode();
        List<Integer> list = print0(root);
//        List<Integer> list = print1(root);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> print0(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            list.add(root.getData());
            root = root.getRight();
        }
        return list;
    }

    public static List<Integer> print1(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public static void inorder(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft(), list);
        list.add(root.getData());
        inorder(root.getRight(), list);
    }
}
