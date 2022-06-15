package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/14 9:55 下午
 * @Version 1.0
 */
public class Demo226 {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }
}
