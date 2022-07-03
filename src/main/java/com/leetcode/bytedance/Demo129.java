package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/6 11:16 下午
 * @Version 1.0
 */
public class Demo129 {

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

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int preVal) {
        if (node == null) return;
        preVal = 10 * preVal + node.val;
        if (node.left == null && node.right == null)
            sum += preVal;
        dfs(node.left, preVal);
        dfs(node.right, preVal);
    }
}
