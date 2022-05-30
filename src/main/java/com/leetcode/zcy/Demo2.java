package com.leetcode.zcy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 判断一个链表是否为回文
 *
 * @Author milindeyu
 * @Date 2022/3/26 9:44 下午
 * @Version 1.0
 */
public class Demo2 {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindromeNodeOne(Node node) {
        if (node == null || node.next == null) return true;

        Deque<Node> stack = new ArrayDeque<>();
        Node current = node;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 判断单链表是否为回文，使用链表大小一半的空间
     * @param node
     * @return
     */
    public static boolean isPalindromeNodeTwo(Node node) {
        if (node == null || node.next == null) return true;

        // 使用快慢指针来判断需要多大的栈空间（慢指针s走一步同时快指针走两步）
        Node current = node;
        Node right = node;
        while (current.next != null && current.next.next != null) {
           right = right.next;
           current = current.next.next;
        }

        Deque<Node> stack = new ArrayDeque<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (node.val != stack.pop().val) return false;
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(2, new Node(1))));
        System.out.println(isPalindromeNodeTwo(node));
    }
}
