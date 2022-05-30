package com.leetcode.bytedance;

import java.util.Stack;

/**
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @Author milindeyu
 * @Date 2022/3/19 3:05 下午
 * @Version 1.0
 */
public class Demo206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode current = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (current == null) {
                result = current = node;
                continue;
            }
            current.next = node;
            current = current.next;
            // 注意，此时要断开最开始节点的下个节点，避免链表成圈死循环
            if (stack.size() == 0) {
                current.next = null;
            }
        }
        return result;
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
