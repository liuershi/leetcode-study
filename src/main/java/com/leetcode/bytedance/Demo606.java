package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/26 4:06 下午
 * @Version 1.0
 */
public class Demo606 {

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

    public String tree2str(TreeNode root) {
        StringBuilder rsp = new StringBuilder();
        if (root == null) rsp.toString();
        dfs(root, rsp, 0);
        return rsp.toString();
    }

    private void dfs(TreeNode node, StringBuilder rsp, int depth) {
        if (node == null) return;
        if (depth != 0) rsp.append("(");
        rsp.append(node.val);
        dfs(node.left, rsp, depth + 1);
        if (depth != 0 && node.left == null && node.right != null) {
            rsp.append("()");
        }
        dfs(node.right, rsp, depth + 1);
        if (depth != 0) rsp.append(")");
    }
}
