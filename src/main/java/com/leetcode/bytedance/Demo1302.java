package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/8/17 11:44 下午
 * @Version 1.0
 */
public class Demo1302 {

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

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int res = 0;
        while (!stack.isEmpty()) {
            res = 0;
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                res += node.val;
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
        }
        return res;
    }
}
