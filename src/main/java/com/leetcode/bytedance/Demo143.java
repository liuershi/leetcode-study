package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/3/19 1:37 下午
 * @Version 1.0
 */
public class Demo143 {

    public void reorderList(ListNode head) {
        ListNode current = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        List<ListNode> list = new ArrayList<>();
        int length = 0;
        while (current != null) {
            if (length % 2 == 0) {
                list.add(current);
            } else {
                stack.addFirst(current);
            }
            current = current.next;
            ++length;
        }
        ListNode currentNode = head;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).next = stack.pop();
            if (i == list.size() - 1) {
                list.get(i).next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        new Demo143().reorderList(node);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        protected Object clone() {
            return this;
        }
    }
}
