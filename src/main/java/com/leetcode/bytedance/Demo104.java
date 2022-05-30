package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/4/26 1:46 上午
 * @Version 1.0
 */
public class Demo104 {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {
        return process(root, 0);
    }

    private static int process(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        int l = process(node.left, depth);
        int r = process(node.right, depth);
        return Math.max(l, r);
    }
}
