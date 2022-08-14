package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/8/14 10:42 下午
 * @Version 1.0
 */
public class Offer55I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode node) {
//        return method1(root);
        // 方法二：基于递归
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    /**
     * 基于宽度优先遍历
     * @param root
     * @return
     */
    private int method1(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int res = 0;
        while (!stack.isEmpty()) {
            res++;
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
        }
        return res;
    }
}
