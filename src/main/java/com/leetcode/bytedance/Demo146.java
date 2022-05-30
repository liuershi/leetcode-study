package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode-cn.com/problems/lru-cache/
 *
 * @Author milindeyu
 * @Date 2022/3/19 1:37 下午
 * @Version 1.0
 */
public class Demo146 {

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Demo146(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.key);
                removeTailNode();
            }
            addToHead(node);
            map.put(key, node);
            return;
        }
        node.value = value;
        moveToHead(node);
    }

    private void addToHead(Node node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    /**
     * 移除尾节点
     */
    private void removeTailNode() {
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;
    }

    /**
     * 将当前节点移到头节点
     * @param node
     */
    private void moveToHead(Node node) {
        if (head == node) {
            return;
        } else if (tail == node) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append("[").append(node.key).append(":").append(node.value).append("]").append("  ");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Demo146 demo = new Demo146(3);
        demo.put(1, 1);
        demo.put(2, 2);
        demo.put(3, 3);
        demo.get(2);
        System.out.println(demo);
        demo.put(4, 4);
        System.out.println(demo);
    }
}
