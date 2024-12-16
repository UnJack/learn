package org.learn.tech.leetcode.btree;

import org.learn.tech.leetcode.common.TreeNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @link 二叉树的层序遍历
 * </br>
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 * </a>
 */
public class test04 {

    public static void main(String[] args) {
//                   1
//              11      12
//           13    14  15   16
        TreeNode<Integer> root = TreeNodeFactory.getTreeNode();
        List<List<Integer>> list = print(root);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> print(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> node = queue.poll();
                assert node != null;
                list.add(node.getData());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            result.add(list);
        }
        return result;
    }
}
