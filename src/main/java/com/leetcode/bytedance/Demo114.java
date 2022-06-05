package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 21:46
 */
public class Demo114 {

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

    TreeNode prev;

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (prev != null) {
            prev.left = null;
            prev.right = node;
        }
        if (node.left == null && node.right == null)
            prev = node;
        prev = node;
        dfs(node.left);
        dfs(node.right);
    }
}
