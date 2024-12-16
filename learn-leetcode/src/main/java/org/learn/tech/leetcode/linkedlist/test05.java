package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 删除链表的节点
 * </br>
 * <a href="https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/solutions/167212/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/">
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/solutions/167212/mian-shi-ti-18-shan-chu-lian
 * -biao-de-jie-dian-sh-2/
 * </a></br>
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 * </a></br>
 * <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/">
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * </a>
 */
public class test05 {
    public static void main(String[] args) {
//        10->11->12->13->12
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode();
        LinkedListNode<Integer> head0 = deleteNode0(head, 12);
        while (head0 != null) {
            System.out.print(head0.getData() + "->");
            head0 = head0.getNext();
        }
    }

    /**
     * 删除节点
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
     * 删除data节点
     *
     * @param head
     * @param data
     * @return
     */
    public static LinkedListNode<Integer> deleteNode1(LinkedListNode<Integer> head, int data) {
        LinkedListNode<Integer> pre = head;
        LinkedListNode<Integer> current = head.getNext();
        while (current != null && current.getData() != data) {
            pre = current;
            current = current.getNext();
        }
        assert current != null;
        pre.setNext(current.getNext());
        return head;
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public static void deleteNode2(LinkedListNode<Integer> node) {
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }
}
