package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/7/24 6:57 下午
 * @Version 1.0
 */
public class Demo155 {

    class MinStack {

        class Node {
            int val;
            int min;
            Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Node head;

        public MinStack() {

        }

        public void push(int val) {
            Node node = new Node(val, val);
            if (head == null) {
                head = node;
                return;
            }
            node.min = Math.min(val, head.min);
            node.next = head;
            head = node;
        }

        public void pop() {
            if (head == null) return;
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
