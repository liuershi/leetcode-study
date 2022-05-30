package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/24 10:27 下午
 * @Version 1.0
 */
public class Demo61 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;

        ListNode current = head, tail = head;
        int size = 0;
        while (current != null) {
            size++;
            if (current.next == null)
                tail = current;
            current = current.next;
        }

        int offset = (size - size % k) % size;
        if (offset == 0)
            return head;
        current = head;
        while (offset-- > 0)
            current = current.next;
        ListNode rsp = current.next;
        current.next = null;
        tail.next = head;
        return rsp;
    }
}
