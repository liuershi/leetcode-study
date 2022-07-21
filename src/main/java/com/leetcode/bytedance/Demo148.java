package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/7/18 11:02 下午
 * @Version 1.0
 */
public class Demo148 {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 使用归并排序实现
        // 1.快慢指针得到当前链表的中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        // 2.断开链表两部分
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 3.创建辅助节点
        ListNode dummyNode = new ListNode();
        ListNode rsp = dummyNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummyNode.next = left;
                left = left.next;
            } else {
                dummyNode.next = right;
                right = right.next;
            }
            dummyNode = dummyNode.next;
        }
        dummyNode.next = left != null ? left : right;
        return rsp.next;
    }

    /**
     * 普通迭代的方式
     *      时间复杂度：O(logn * logn)
     *      空间复杂度: O(n)
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode root = head;
        while (root != null) {
            queue.add(root);
            root = root.next;
        }

        ListNode current, prev = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (queue.isEmpty()) current.next = null;
            if (root == null) root = prev = current;
            else {
                if (prev != null) prev.next = current;
                prev = current;
            }
        }
        return root;
    }
}
