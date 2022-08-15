package com.leetcode.bytedance;

/**
 * 设计双端队列
 *
 * @author zhangwei151
 * @date 2022/8/15 10:26
 */
public class Demo641 {

    class MyCircularDeque {

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head, tail;
        int capacity;
        int size;

        public MyCircularDeque(int k) {
            this.capacity = k;
        }

        public boolean insertFront(int value) {
            if (size == capacity) return false;
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (capacity == size) return false;
            Node node = new Node(value);
            if (tail == null) {
                head = tail = node;
             } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (head == null) return false;
            else if (head == tail) head = tail = null;
            else {
                head.next.prev = null;
                head = head.next;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (tail == null) return false;
            else if (head == tail) head = tail = null;
            else {
                tail.prev.next = null;
                tail = tail.prev;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (head == null) return -1;
            return head.val;
        }

        public int getRear() {
            if (tail == null) return -1;
            return tail.val;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
