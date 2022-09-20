package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/2 12:37 上午
 * @Version 1.0
 */
public class Demo687 {

    public static class TreeNode {
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

    int res;
    public int longestUnivaluePath(TreeNode node) {
        // 思路：dfs，自底向上的递归，遍历左右右节点，用遍历记录当前遍历时的最大长度
        // 向上返回时只能返回左节点或右节点的最大长度，否则可能形成左右子链表加上父亲
        // 节点长度的情况，即向上返回只返回当前子节点某一边的最大长度
        dfs(node);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left), right = dfs(node.right);
        int lMax = 0, rMax = 0;
        if (node.left != null && node.left.val == node.val) lMax = left + 1;
        if (node.right != null && node.right.val == node.val) rMax = right + 1;
        res = Math.max(res, lMax + rMax);
        return Math.max(lMax, rMax);
    }
}
