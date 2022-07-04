package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/27 11:26 下午
 * @Version 1.0
 */
public class Demo671 {

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

    int rsp = -1, rootValue;
    public int findSecondMinimumValue(TreeNode root) {
        rootValue = root.val;
        dfs(root);
        return rsp;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (rsp != -1 && node.val > rsp) return;
        if (node.val > rsp) rsp = node.val;
        dfs(node.left);
        dfs(node.right);
    }
}
