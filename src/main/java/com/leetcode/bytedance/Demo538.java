package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/22 11:56 下午
 * @Version 1.0
 */
public class Demo538 {

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

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    int base;
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        base += node.val;
        node.val = base;
        dfs(node.left);
    }
}
