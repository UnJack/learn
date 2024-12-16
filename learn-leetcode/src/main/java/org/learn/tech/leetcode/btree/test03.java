package org.learn.tech.leetcode.btree;

import org.learn.tech.leetcode.common.TreeNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @link 后序遍历，左右根
 * </br>
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 * </a>
 */
public class test03 {
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

    /**
     * 不使用递归输出后续遍历
     *
     * @param root
     * @return
     */
    public static LinkedList<Integer> print0(TreeNode<Integer> root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            linkedList.addFirst(node.getData());
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        return linkedList;
    }

    public static List<Integer> print1(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 递归输出后续遍历
     *
     * @param root
     */
    public static void inorder(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft(), list);
        inorder(root.getRight(), list);
        list.add(root.getData());
    }
}
