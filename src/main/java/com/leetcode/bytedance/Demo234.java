package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/6/29 9:29 下午
 * @Version 1.0
 */
public class Demo234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 1.先拿到链表中点
        ListNode middleNode = middleNode(head);
        // 2.反转后半段链表
        ListNode postNode = middleNode.next;
        middleNode.next = null;
        ListNode reversalNode = reversalNode(postNode);
        // 3.比较原链表和反转的链表
        while (reversalNode != null) {
            if (head.val != reversalNode.val) return false;
            head = head.next;
            reversalNode = reversalNode.next;
        }
        return true;
    }

    /**
     * 反转链表
     * @param node
     */
    private ListNode reversalNode(ListNode node) {
        if (node.next == null) return null;
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 获取链表的中间节点
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
