package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangwei151
 * @date 2022/6/4 17:25
 */
public class Demo99 {

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

    TreeNode prev, node1, node2;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap();
    }

    private void swap() {
        if (node1 != null && node2 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    private void dfs(TreeNode current) {
        if (current == null) return;

        dfs(current.left);
        if (prev != null && prev.val > current.val) {
            if (node1 == null) node1 = prev;
            node2 = current;
        }
        prev = current;
        dfs(current.right);
    }
}
