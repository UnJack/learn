package org.learn.tech.leetcode.common;

public class TreeNodeFactory {

    public static TreeNode<Integer> getTreeNode() {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node1 = new TreeNode<>(11);
        TreeNode<Integer> node2 = new TreeNode<>(12);
        TreeNode<Integer> node3 = new TreeNode<>(13);
        TreeNode<Integer> node4 = new TreeNode<>(14);
        TreeNode<Integer> node5 = new TreeNode<>(15);
        TreeNode<Integer> node6 = new TreeNode<>(16);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        return root;
    }

    /**
     * 有重复元素链表
     *
     * @return
     */
    public static LinkedListNode<Integer> getRepeatLinkedListNode() {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(7);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return head;
    }

    /**
     * 无重复元素链表
     *
     * @return
     */
    public static LinkedListNode<Integer> getNoneRepeatLinkedListNode() {
        LinkedListNode<Integer> head = new LinkedListNode<>(2);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(6);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(8);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(10);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return head;
    }

    /**
     * 带有死循环的链表
     *
     * @return
     */
    public static LinkedListNode<Integer> getCycleLinkedListNode() {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node2);
        return head;
    }
}
