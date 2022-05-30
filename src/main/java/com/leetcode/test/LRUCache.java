package com.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现lru算法
 *
 * @Author milindeyu
 * @Date 2022/5/17 11:18 下午
 * @Version 1.0
 */
public class LRUCache {

    int capacity;

    Map<Integer, Node> container;

    Node head;
    Node tail;

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        container = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = container.get(key);
        if (node == null)
            return -1;

        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        if (node == head) return;
        else if (tail == node) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void put(int key, int val) {
        Node node = container.get(key);
        if (node == null) {
            node = new Node(key, val);
            if (capacity == container.size()) {
                container.remove(tail.key);
                removeTailNode();
            }
            addHead(node);
            container.put(key, node);
            return;
        }
        node.val = val;
        moveToHead(node);
    }

    private void addHead(Node node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void removeTailNode() {
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;
    }
}
