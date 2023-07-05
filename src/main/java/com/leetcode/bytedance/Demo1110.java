package com.leetcode.bytedance;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author milindeyu
 * @Date 2023/5/30 12:49 上午
 * @Version 1.0
 */
public class Demo1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>(to_delete.length);
        for (int i : to_delete) {
            set.add(i);
        }

        List<TreeNode> ans = new ArrayList<>();
        if (!set.contains(root.val)) {
            ans.add(root);
        }
        dfs(root, set, ans);
        return ans;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> ans) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, set, ans);
        node.right = dfs(node.right, set, ans);

        if (set.contains(node.val)) {
            if (node.left != null) {
                ans.add(node.left);
            }
            if (node.right != null) {
                ans.add(node.right);
            }
            node = null;
        }
        return node;
    }

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
}
