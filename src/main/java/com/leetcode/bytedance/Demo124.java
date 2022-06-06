package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/6 10:59 下午
 * @Version 1.0
 */
public class Demo124 {

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

    List<TreeNode> inOrderPath = new ArrayList<>();

    public int maxPathSum(TreeNode root) {
        dfs(root);
        // todo
        return 0;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        inOrderPath.add(node);
        dfs(node.right);
    }
}
