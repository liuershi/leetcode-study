package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/29 12:46 上午
 * @Version 1.0
 */
public class Demo876 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        // 基于快慢指针实现
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else break;
        }
        return slow;
    }
}
