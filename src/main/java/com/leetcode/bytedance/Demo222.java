package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/14 9:47 下午
 * @Version 1.0
 */
public class Demo222 {
    
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

    int rsp = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return rsp;
        rsp++;
        dfs(root.left, root.right);
        return rsp;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return;
        if (left != null) {
            rsp++;
            dfs(left.left, left.right);
        }
        if (right != null) {
            rsp++;
            dfs(right.left, right.right);
        }
    }
}
