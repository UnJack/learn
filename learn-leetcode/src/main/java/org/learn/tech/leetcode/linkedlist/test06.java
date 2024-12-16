package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 链表反转
 * </br>
 * <a href="https://leetcode.cn/problems/reverse-linked-list/submissions/586325540/">
 * https://leetcode.cn/problems/reverse-linked-list/submissions/586325540/
 * </a>
 */
public class test06 {

    public static void main(String[] args) {
//        10->11->12->13->14->15->16
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode();
        LinkedListNode<Integer> head0 = reverseList(head);
        while (head0 != null) {
            System.out.print(head0.getData() + "->");
            head0 = head0.getNext();
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> pre = null;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            LinkedListNode<Integer> next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

}
