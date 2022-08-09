package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/8/2 9:59
 */
public class Demo622 {

    /**
     * 设计循环队列
     */
    class MyCircularQueue {

        class Node {
            int val;
            Node prev, next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head, tail;
        // 队列容量大小
        int capacity;
        // 当前队列元素大小
        int size;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.size = 0;
        }

        /**
         *  向循环队列插入一个元素。如果成功插入则返回真
         * @param value
         * @return
         */
        public boolean enQueue(int value) {
            if (size == capacity) return false;
            Node node = new Node(value);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }

        /**
         * 从循环队列中删除一个元素。如果成功删除则返回真
         * @return
         */
        public boolean deQueue() {
            if (head == null) return false;
            else if (head == tail) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = head.next;
            }
            size--;
            return true;
        }

        /**
         * 从队首获取元素。如果队列为空，返回 -1
         * @return
         */
        public int Front() {
            if (head == null) return -1;
            return head.val;
        }

        /**
         * 获取队尾元素。如果队列为空，返回 -1
         * @return
         */
        public int Rear() {
            if (tail == null) return -1;
            return tail.val;
        }

        /**
         * 检查循环队列是否为空
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 检查循环队列是否已满
         * @return
         */
        public boolean isFull() {
            return size == capacity;
        }
    }
}
