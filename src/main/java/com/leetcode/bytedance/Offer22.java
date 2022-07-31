package com.leetcode.bytedance;

/**
 * 链表中倒数第k个节点
 *
 * @Author milindeyu
 * @Date 2022/7/31 10:28 下午
 * @Version 1.0
 */
public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 先快慢指针确定链表长度
        ListNode slow = head, fast = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            len += 2;
        }
        if (fast != null) len++;

        len -= k;
        while (len-- > 0) {
            head = head.next;
        }
        return head;
    }
}
