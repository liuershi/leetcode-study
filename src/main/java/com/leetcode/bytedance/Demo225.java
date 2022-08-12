package com.leetcode.bytedance;

/**
 * 用队列实现一个栈
 *
 * @Author milindeyu
 * @Date 2022/8/13 12:24 上午
 * @Version 1.0
 */
public class Demo225 {

    class MyStack {

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head, tail;

        public MyStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public int pop() {
            Node node = tail;
            if (head == tail) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
            return node.val;
        }

        public int top() {
            return tail.val;
        }

        public boolean empty() {
            return head == null;
        }
    }
}
