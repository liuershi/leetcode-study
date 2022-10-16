package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/10/16 6:44 下午
 * @Version 1.0
 */
public class Demo337 {
    
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

    // 缓存计算结果，避免重复计算
    Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        // 方式一：dfs
        // 思路：以根节点为入口，或者其左右子节点为入口比较大小
        if (root == null) return 0;
        if (cache.get(root) != null) return cache.get(root);
        int sum = 0;
        if (root.left != null) sum += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) sum += rob(root.right.left) + rob(root.right.right);
        int max = Math.max(rob(root.left) + rob(root.right), root.val + sum);
        cache.put(root, max);
        return max;
    }
}
