package org.learn.tech.leetcode.common;

import lombok.Data;

/**
 * 链表节点
 *
 * @param <T>
 */
@Data
public class LinkedListNode<T> {

    private LinkedListNode<T> next;
    private T data;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(LinkedListNode<T> next, T data) {
        this.next = next;
        this.data = data;
    }
}
