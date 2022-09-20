package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/28 10:07 下午
 * @Version 1.0
 */
public class Offer36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 当前处理节点和头节点
     */
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 首尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);

        if (pre == null) head = node;
        else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        dfs(node.right);
    }
}
