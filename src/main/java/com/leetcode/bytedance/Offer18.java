package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 5:49 下午
 * @Version 1.0
 */
public class Offer18 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null ) return null;
        if (head.val == val) return head.next;
        ListNode node = head.next, prev = head;
        while (node != null) {
            if (node.val == val) {
                ListNode next = node.next;
                node.next = null;
                prev.next = next;
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
