package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/18 6:52 下午
 * @Version 1.0
 */
public class OfferII029 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.val == insertVal || head.next == head) {
            node.next = head.next;
            head.next = node;
            return head;
        }
        Node current = head;
        while (true) {
            int val = current.val;
            if (val == insertVal
                    || (val < insertVal && current.next.val > insertVal)
                    || (insertVal > val && val > current.next.val)
                    || (val > current.next.val && insertVal < current.next.val)) {
                Node next = current.next;
                current.next = node;
                node.next = next;
                break;
            }
            // 查找到一圈也为找到时
            if (current.next == head) {
                current.next = node;
                node.next = head;
                break;
            }
            current = current.next;
        }
        return head;
    }
}
