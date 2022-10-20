package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/20 11:12 下午
 * @Version 1.0
 */
public class Demo783 {
    
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
    public int minDiffInBST(TreeNode node) {
        // 思路：dfs，中序遍历
        if (node == null) return 0;
        dfs(node);
        return rsp;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (base != -1) {
            rsp = Math.min(rsp, Math.abs(node.val - base));
        }
        base = node.val;
        dfs(node.right);
    }
}
