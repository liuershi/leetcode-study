package com.leetcode.bytedance;

import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2022/7/21 11:01 下午
 * @Version 1.0
 */
public class Demo814 {

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

    public TreeNode pruneTree(TreeNode root) {
        return shouldDelete(root) ? null : root;
    }

    private boolean shouldDelete(TreeNode node) {
        if (node == null) return true;

        boolean leftDel = shouldDelete(node.left);
        boolean rightDel = shouldDelete(node.right);
        if (leftDel) node.left = null;
        if (rightDel) node.right = null;
        return leftDel && rightDel && node.val == 0;
    }
}
