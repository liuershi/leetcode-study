package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/12 9:48 下午
 * @Version 1.0
 */
public class Demo141 {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            if (fast.next == null) {
                fast = null;
                continue;
            }
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
