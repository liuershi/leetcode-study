package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/14 10:06 下午
 * @Version 1.0
 */
public class Demo230 {

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

    int count = 0;
    int rsp = -1;

    public int kthSmallest(TreeNode root, int k) {
        // 二叉搜索树的中序遍历即为顺序
        dfs(root, k);
        return rsp;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || rsp != -1) return;
        dfs(node.left, k);
        if (++count == k) {
            rsp = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
