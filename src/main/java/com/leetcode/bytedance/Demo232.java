package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 5:39 下午
 * @Version 1.0
 */
public class Demo232 {

    class MyQueue {

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head, tail;

        public MyQueue() {

        }

        public void push(int x) {
            Node node = new Node(x);
            if (head == null) head = tail = node;
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public int pop() {
            Node node = head;
            if (head.next == null) head = tail = null;
            else {
                head.next.prev = null;
                head = head.next;
            }
            return node.val;
        }

        public int peek() {
            return head.val;
        }

        public boolean empty() {
            return head == null;
        }
    }
}
