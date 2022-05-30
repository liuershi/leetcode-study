package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/24 10:58 下午
 * @Version 1.0
 */
public class Demo965 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean rsp = true;
    private int val;

    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        process(root);
        return rsp;
    }

    private void process(TreeNode root) {
        if (!rsp || root == null) return;
        if (root.val != val) {
            rsp = false;
            return;
        }
        process(root.left);
        process(root.right);
    }
}
