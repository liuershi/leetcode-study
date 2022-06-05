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

    Map<Integer, List<Node>> map = new HashMap<>();

    public Node connect(Node root) {
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

    private void dfs(Node node, int depth) {
        if (node == null) return;
        ++depth;
        map.putIfAbsent(depth, new ArrayList<>());
        map.get(depth).add(node);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
