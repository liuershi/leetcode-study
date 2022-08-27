package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 9:57 下午
 * @Version 1.0
 */
public class Offer30 {

    class MinStack {

        class Node {
            int val;
            int min; // 存放当前最小的值
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Node tail;

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            Node node = new Node(x, tail == null ? x : Math.min(tail.min, x));
            if (tail == null) tail = node;
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public void pop() {
            if (tail.prev == null) {
                tail = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
        }

        public int top() {
            return tail.val;
        }

        public int min() {
            return tail.min;
        }
    }
}
