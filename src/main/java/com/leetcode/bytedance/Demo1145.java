package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/3 12:36 上午
 * @Version 1.0
 */
public class Demo1145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode xNode;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);
        int left = subNodeCount(xNode.left);
        int right = subNodeCount(xNode.right);
        int other = n - left - right - 1;
        int half = (n + 1) >> 1;
        return left >= half || right >= half || other >= half;
    }

    private int subNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + subNodeCount(node.left) + subNodeCount(node.right);
    }

    private void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }

        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }
}
