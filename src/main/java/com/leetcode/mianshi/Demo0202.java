package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/10/16 7:36 下午
 * @Version 1.0
 */
public class Demo0202 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) return 0;
        int len = 0;
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            len += 2;
        }
        if (slow != null) len++;

        len -= k;
        while (len-- > 0) {
            head = head.next;
        }
        return head.val;
    }
}
