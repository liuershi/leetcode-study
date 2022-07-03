package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/22 11:06 下午
 * @Version 1.0
 */
public class Demo530 {

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

    int base = -1, rsp = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return rsp;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (base == -1) base = node.val;
        else {
            rsp = Math.min(rsp, Math.abs(base - node.val));
            base = node.val;
        }
        dfs(node.right);
    }
}
