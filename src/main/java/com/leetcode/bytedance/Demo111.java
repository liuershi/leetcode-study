package com.leetcode.bytedance;/**
 *
 * @author zhangwei151
 * @date 2022/6/5 20:03
 */
public class Demo111 {

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


    int rsp = 100001;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return rsp;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > rsp) return;
        if (node.left == null && node.right == null) {
            rsp = depth;
            return;
        }
        depth++;
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
