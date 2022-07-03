package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/26 3:51 下午
 * @Version 1.0
 */
public class Demo590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> rsp = new ArrayList<>();
        if (root == null) return rsp;
        dfs(root, rsp);
        return rsp;
    }

    private void dfs(Node node, List<Integer> rsp) {
        if (node == null) return;
        for (Node child : node.children) {
            dfs(child, rsp);
        }
        rsp.add(node.val);
    }
}
