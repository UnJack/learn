package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

/**
 * @link 合并两个有序链表
 * </br>
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/submissions/586030260/">
 * https://leetcode.cn/problems/merge-two-sorted-lists/submissions/586030260/
 * </a>
 */
public class test05 {

    public static void main(String[] args) {
//        1->3->5->5->7
        LinkedListNode<Integer> head1 = TreeNodeFactory.getRepeatLinkedListNode();
//        2->4->6->8->10
        LinkedListNode<Integer> head2 = TreeNodeFactory.getNoneRepeatLinkedListNode();
        LinkedListNode<Integer> mergeNode = mergeNode(head1, head2);
        while (mergeNode != null) {
            System.out.print(mergeNode.getData() + "->");
            mergeNode = mergeNode.getNext();
        }
    }

    /**
     * 合并链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static LinkedListNode<Integer> mergeNode(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.getData() < head2.getData()) {
            head1.setNext(mergeNode(head1.getNext(), head2));
            return head1;
        } else {
            head2.setNext(mergeNode(head1, head2.getNext()));
            return head2;
        }
    }
}
