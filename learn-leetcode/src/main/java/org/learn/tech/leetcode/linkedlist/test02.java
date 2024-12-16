package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 有序链表转换二叉搜索树
 * </br>
 * <a href="https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/">
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/
 * </a>
 */
public class test02 {

    public static void main(String[] args) {
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode();
        print(head);
        LinkedListNode<Integer> midNode = getMidNode(head, null);
        System.out.println("midNode.getData() = " + midNode.getData());
    }

    public static void print(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> root = head;
        while (root != null) {
            System.out.print(root.getData() + " ");
            root = root.getNext();
        }
    }

    public static TreeNode<Integer> buildTree(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
        if (left == right) {
            return null;
        }
        LinkedListNode<Integer> midNode = getMidNode(left, right);
        TreeNode<Integer> root = new TreeNode<>(midNode.getData());
        root.setLeft(buildTree(left, midNode));
        root.setRight(buildTree(midNode.getNext(), right));
        return root;
    }

    /**
     * 获取中间节点
     *
     * @param left
     * @param right
     * @return
     */
    public static LinkedListNode<Integer> getMidNode(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
        LinkedListNode<Integer> slow = left;
        LinkedListNode<Integer> fast = left;
        while (fast != right && fast.getNext() != right) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}
