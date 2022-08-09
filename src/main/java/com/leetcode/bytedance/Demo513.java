package com.leetcode.bytedance;

import java.util.*;

/**
 * @author zhangwei151
 * @date 2022/6/22 16:44
 */
public class Demo513 {
    
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

    int rsp;
    int depth = -1;
    public int findBottomLeftValue(TreeNode root) {
        // 基于深度优先搜索
        if (root == null) return 0;
        dfs(0, root);
        return rsp;
    }

    private void dfs(int depth, TreeNode node) {
        if (node == null) return;
        if (depth > this.depth && node.left == null && node.right == null) {
            rsp = node.val;
            this.depth = depth;
        }
        dfs(depth + 1, node.left);
        dfs(depth + 1, node.right);
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    private int method1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, Integer> map = new HashMap<>();
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                map.putIfAbsent(depth, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return map.get(--depth);
    }
}
