package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/10/22 9:29 下午
 * @Version 1.0
 */
public class Offer35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 存储链表节点和其random节点值的映射关系
        Map<Node, Node> randomCache = new HashMap<>();
        Node rsp = null, cur = null, node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            if (rsp == null) {
                rsp = cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
            randomCache.put(node, newNode);
            node = node.next;
        }

        node = head;
        while (node != null) {
            randomCache.get(node).random = randomCache.get(node.random);
            node = node.next;
        }
        return rsp;
    }
}
