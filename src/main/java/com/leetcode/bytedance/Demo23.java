package com.leetcode.bytedance;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/3/20 2:07 下午
 * @Version 1.0
 */
public class Demo23 {
    /**
     * 方法一：使用优先级队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode result = null;
        ListNode current = null;
        while (queue.size() != 0) {
            Integer integer = queue.poll();
            if (result == null) {
                result = current = new ListNode(integer);
                continue;
            }
            current.next = new ListNode(integer);
            current = current.next;
        }
        return result;
    }

    /**
     * 方法二：使用递归
     * @param lists
     * @return
     */
    public ListNode mergeKListsTwo(ListNode[] lists) {
        ListNode current = null;
        for (ListNode node : lists) {
            current = mergeTwoListNode(current, node);
        }
        return current;
    }

    private ListNode mergeTwoListNode(ListNode current, ListNode node) {
        if (current == null || node == null) {
            return current == null ? node : current;
        }
        if (current.val < node.val) {
            current.next = mergeTwoListNode(current, node.next);
            return current;
        } else {
            node.next = mergeTwoListNode(current, node.next);
            return node;
        }
    }

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
}
