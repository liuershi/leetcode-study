package com.leetcode.bytedance;

import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/29 12:12 上午
 * @Version 1.0
 */
public class Demo203 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
//        return method1(head, val);

        // 递归的方式
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 普通迭代判断
     * @param head
     * @param val
     * @return
     */
    private ListNode method1(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head == null ? null : head.next, prev = head;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
