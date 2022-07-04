package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/3/19 1:37 下午
 * @Version 1.0
 */
public class Demo143 {

    public void reorderList(ListNode head) {
//        method(head);

        if (head == null) return;
        // 链表中点+链表翻转+合并链表 实现
        // 1.链表中点：通过快慢指针实现
        ListNode middleNode = middleLiseNode(head);
        // 2.链表翻转
        ListNode next = middleNode.next;
        middleNode.next = null;
        ListNode reversalNode = reversalLiseNode(next);
        // 3.合并链表
        mergeLiseNode(head, reversalNode);
    }

    private void mergeLiseNode(ListNode head, ListNode reversalNode) {
        ListNode node1 = head, node2 = reversalNode;
        while (node1 != null && node2 != null) {
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;
            node1.next = node2;
            node2.next = next1;
            node1 = next1;
            node2 = next2;
        }
    }

    /**
     * 反转指定链表
     * @param node
     */
    private ListNode reversalLiseNode(ListNode node) {
        if (node == null) return null;
        ListNode cur = node, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 获取指定链表的中间节点
     * @param head
     * @return
     */
    public ListNode middleLiseNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 迭代链表实现。
     * 时间、空间复杂度高
     * @param head
     */
    private void method(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            deque.offerLast(current);
            current = next;
        }
        while (!deque.isEmpty()) {
            if (current == null) {
                head = current = deque.pollFirst();
                current.next = deque.pollLast();
                current = current.next;
            } else {
                current.next = deque.pollFirst();
                current = current.next;
                current.next = deque.pollLast();
                current = current.next;
            }
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        protected Object clone() {
            return this;
        }
    }
}
