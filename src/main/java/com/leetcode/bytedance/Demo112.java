package com.leetcode.bytedance;/**
 *
 * @author zhangwei151
 * @date 2022/6/5 20:54
 */
public class Demo112 {

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

    boolean rsp = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return rsp;
        dfs(root, 0, targetSum);
        return rsp;
    }

    private void dfs(TreeNode node, int currentSum, int targetSum) {
        if (rsp || node == null) return;
        if (node.left == null && node.right == null) {
            rsp = currentSum == targetSum;
            return;
        }
        currentSum += node.val;
        dfs(node.left, currentSum, targetSum);
        dfs(node.right, currentSum, targetSum);
    }
}
