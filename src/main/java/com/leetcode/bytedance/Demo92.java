package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/5/29 2:12 下午
 * @Version 1.0
 */
public class Demo92 {

    
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 取得left下标的前驱节点
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 取得right下标的节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 取得left节点
        ListNode leftNode = pre.next;
        // 取得right下标的后继节点
        ListNode post = rightNode.next;
        // 断开right的后继节点
        rightNode.next = null;

        // 反转left到right下标的链表
        reversalNode(leftNode);

        pre.next = rightNode;
        leftNode.next = post;

        return dummyNode.next;
    }


    public void reversalNode(ListNode left) {
        ListNode prev = null, current = left;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    /**
     * 自己写的方法，实现需求了，但是逻辑混乱
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode method01(ListNode head, int left, int right) {
        ListNode rsp = null;
        Deque<ListNode> stack = new ArrayDeque<>();
        int index = 0;
        ListNode searchNode = head;
        ListNode headNode = null, tailNode = null;
        while (index++ < right && searchNode != null) {
            if (index + 1 == left)
                headNode = searchNode;
            if (index >= left && index <= right) {
                stack.push(searchNode);
            }
            searchNode = searchNode.next;
            if (index == right)
                tailNode = searchNode;
        }
        ListNode current = null;
        while (!stack.isEmpty()) {
            if (current == null) {
                current = stack.pop();
                rsp = current;
                continue;
            }
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        if (tailNode != null)
            current.next = tailNode;
        if (headNode != null) {
            headNode.next = rsp;
            rsp = head;
        }
        return rsp;
    }
}
