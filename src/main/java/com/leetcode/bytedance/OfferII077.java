package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/3/2 10:05 下午
 * @Version 1.0
 */
public class OfferII077 {

    class ListNode {
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

    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode node = head;
        while (node != null) {
            queue.add(node);
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
        }

        return dummy.next;
    }
}
