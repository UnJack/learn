package org.learn.tech.leetcode.linkedlist;

import org.learn.tech.leetcode.common.LinkedListNode;
import org.learn.tech.leetcode.common.TreeNodeFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @link 环形链表
 * </br>
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">
 * https://leetcode.cn/problems/linked-list-cycle/
 * </a>
 */
public class test07 {

    public static void main(String[] args) {
        LinkedListNode<Integer> head = TreeNodeFactory.getLinkedListNode2();
        System.out.println(hasCycle1(head));
        System.out.println(hasCycle2(head));
    }

    public static boolean hasCycle1(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.getNext();
        while (fast != slow) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return true;
    }

    public static boolean hasCycle2(LinkedListNode<Integer> head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head.getData())) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }
}
