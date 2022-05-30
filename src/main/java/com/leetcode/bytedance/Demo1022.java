package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/30 12:11 上午
 * @Version 1.0
 */
public class Demo1022 {

    
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

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) return 0;
        val  = (val << 1) | node.val;
        if (node.left == null && node.right == null)
            return val;
        return dfs(node.left, val) + dfs(node.right, val);
    }
}
