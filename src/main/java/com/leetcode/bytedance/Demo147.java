package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/7/23 8:53 下午
 * @Version 1.0
 */
public class Demo147 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val);
                if (node.next != null) sb.append("->");
                node = node.next;
            }
            return sb.toString();
        }
    }


    public ListNode insertionSortList(ListNode head) {
        // 直接遍历链表，在原数据基础上更新
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        // 这里使用head遍历
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            // 重置pre，每次从头开始找
            pre = dummy;
            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Demo147 demo147 = new Demo147();

        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        System.out.println(demo147.insertionSortList(node));
    }

    /**
     * 常规做法
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode cur = head;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }

        ListNode rsp = queue.peek();
        cur = queue.poll();
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return rsp;
    }
}
