package com.leetcode.bytedance;

import java.util.*;

/**
 * @author zhangwei151
 * @date 2022/6/6 14:26
 */
public class Demo117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Node last, nextStart;

    public Node connect(Node root) {
        if (root == null) return null;
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                handler(p.left);
                handler(p.right);
            }
            start = nextStart;
        }
        return root;
    }

    private void handler(Node node) {
        if (node == null) return;
        if (last != null)
            last.next = node;
        if (nextStart == null)
            nextStart = node;
        last = node;
    }

    /**
     * 基于广度优先遍历实现，较递归的空间空间复杂度有所提升，因为不需要维护递归的栈空间
     * @param root
     * @return
     */
    private Node method2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            while (size-- > 0) {
                Node node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (pre != null)
                    pre.next = node;
                pre = node;
            }
        }
        return root;
    }


    Map<Integer, Node> depthMapping = new HashMap<>();
    /**
     * 基于递归
     * @param root
     * @return
     */
    private Node method1(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int depth) {
        if (node == null) return;
        if (depthMapping.get(depth) != null)
            depthMapping.get(depth).next = node;
        depthMapping.put(depth, node);
        depth++;
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
