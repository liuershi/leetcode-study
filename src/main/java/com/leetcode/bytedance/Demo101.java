package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 11:44
 */
public class Demo101 {

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

    boolean rsp = true;

    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return rsp;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (!rsp) return;
        if (left == null && right == null) return;
        if (left == null || right == null || left.val != right.val) {
            rsp = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
