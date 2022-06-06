package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 22:47
 */
public class Demo116 {

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

    Map<Integer, Node> depthNodeMap = new HashMap<>();

    public Node connect(Node root) {
//        return method1(root);
//        return method2(root);
        // 实现常量级别的空间复杂度和O(N)时间复杂度
        dfsThree(root, null);
        return root;
    }

    private void dfsThree(Node node, Node right) {
        if (node == null) return;
        node.next = right;
        dfsThree(node.left, node.right);
        dfsThree(node.right, right == null ? null : right.left);
    }

    /**
     * 方式2：相较于方式1时间复杂度更低，空间复杂度也差不多
     * @param root
     * @return
     */
    private Node method2(Node root) {
        dfsTwo(root, 0);
        return root;
    }

    private void dfsTwo(Node node, int depth) {
        if (node == null) return;
        if (depthNodeMap.get(depth) != null)
            depthNodeMap.get(depth).next = node;
        depthNodeMap.put(depth, node);
        depth++;
        dfsTwo(node.left, depth);
        dfsTwo(node.right, depth);
    }

    /**
     * 方式1
     * @param root
     * @return
     */
    private Node method1(Node root) {
        dfs(root, 0);
        for (int i = 1; i < map.keySet().size(); i++) {
            List<Node> nodes = map.get(i);
            for (int i1 = 0; i1 < nodes.size(); i1++) {
                if (i < nodes.size() - 1) {
                    nodes.get(i1).next = nodes.get(i1 + 1);
                }
            }
        }
        return root;
    }

    Map<Integer, List<Node>> map = new HashMap<>();

    private void dfs(Node node, int depth) {
        if (node == null) return;
        ++depth;
        map.putIfAbsent(depth, new ArrayList<>());
        map.get(depth).add(node);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
