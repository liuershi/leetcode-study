package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2024/1/3 10:55 下午
 * @Version 1.0
 */
public class Demo2487 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().next = node;
            }
            stack.push(node);

            node = node.next;
        }

        return stack.removeFirst();
    }
}
