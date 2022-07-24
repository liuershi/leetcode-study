package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/23 3:46 下午
 * @Version 1.0
 */
public class Demo138 {

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

        Map<Node, Node> map = new HashMap<>();
        Node cur = head, prev = null;
        while (cur != null) {
            Node node = new Node(cur.val);
            if (prev == null) prev = node;
            else {
                prev.next = node;
                prev = prev.next;
            }
            map.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
