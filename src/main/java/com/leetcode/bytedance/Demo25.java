package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @link https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @Author milindeyu
 * @Date 2022/3/19 2:02 下午
 * @Version 1.0
 */
public class Demo25 {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode current = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        int index = 1;
        while (head != null) {
           stack.push(new ListNode(head.val, null));
           if (index % k == 0) {
               if (index == k) {
                   current = stack.pop();
                   result = current;
               }
               while (current != null && !stack.isEmpty()) {
                   current.next = stack.pop();
                   current = current.next;
               }
           }
           ++index;
           head = head.next;
        }
        if (!stack.isEmpty()) {
            for (int i = 0; i < stack.size(); i++) {
                ListNode node = stack.elementAt(i);
                if (current == null) {
                    current = node;
                    result = current;
                } else {
                    current.next = node;
                    current = current.next;
                }
            }
        }
        return result;
    }
}
