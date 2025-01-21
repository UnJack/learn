package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 删除链表的节点
 */
public class test04 {

    public static void main(String[] args) {
//        1->3->5->5->7
        LinkedListNode<Integer> head = TreeNodeFactory.getRepeatLinkedListNode();
        LinkedListNode<Integer> head0 = deleteNode1(head, 5);
        while (head0 != null) {
            System.out.print(head0.getData() + "->");
            head0 = head0.getNext();
        }
    }

    /**
     * 给你一个链表的头节点head和一个整数val，请你删除链表中所有满足Node.val == val的节点，并返回新的头节点 。</br>
     * <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">
     * https://leetcode.cn/problems/remove-linked-list-elements/description/
     * </a>
     *
     * @param head
     * @param data
     * @return
     */
    public static LinkedListNode<Integer> deleteNode0(LinkedListNode<Integer> head, int data) {
        if (head == null) {
            return null;
        }
        head.setNext(deleteNode0(head.getNext(), data));
        return head.getData() == data ? head.getNext() : head;
    }

    /**
     * 给你一个链表的头节点head和一个整数val，链表的所有值都是唯一的，删除满足Node.val == val的节点。</br>
     * <a href="https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/solutions/167212/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/">
     * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/solutions/167212/mian-shi-ti-18-shan-chu-lian
     * -biao-de-jie-dian-sh-2/
     * </a>
     *
     * @param head
     * @param data
     * @return
     */
    public static LinkedListNode<Integer> deleteNode1(LinkedListNode<Integer> head, int data) {
        if (head.getData() == data) {
            return head;
        }
        LinkedListNode<Integer> pre = head;
        LinkedListNode<Integer> current = head.getNext();
        while (current != null) {
            if (current.getData() == data) {
                pre.setNext(current.getNext());
            } else {
                pre = current;
            }
            current = current.getNext();
        }
        return head;
    }

    /**
     * 你将无法访问第一个节点head。链表的所有值都是唯一的，并且保证给定的节点node不是链表中的最后一个节点。</br>
     * <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/">
     * https://leetcode.cn/problems/delete-node-in-a-linked-list/
     * </a>
     *
     * @param node
     */
    public static void deleteNode2(LinkedListNode<Integer> node) {
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }
}
