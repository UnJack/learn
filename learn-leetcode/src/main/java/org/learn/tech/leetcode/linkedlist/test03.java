package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 删除链表的倒数第N个节点
 * </br>
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * </a>
 */
public class test03 {

    public static void main(String[] args) {
//        10->11->12->13->14->15->16
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode();
        LinkedListNode<Integer> current = removeNthFromEnd(head, 2);
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
    }

    /**
     * 删除倒数的第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static LinkedListNode<Integer> removeNthFromEnd(LinkedListNode<Integer> head, int n) {
        LinkedListNode<Integer> nilNode = new LinkedListNode<>(0);
        nilNode.setNext(head);
        int length = getLinkedListNodeLength(head);
        LinkedListNode<Integer> current = nilNode;
        for (int i = 1; i < length - n + 1; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        return nilNode.getNext();
    }

    /**
     * 链表长度
     *
     * @param head
     * @return
     */
    public static int getLinkedListNodeLength(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }
}
