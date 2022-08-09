package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/7/31 4:31 下午
 * @Version 1.0
 */
public class Demo1161 {
    
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

    public int maxLevelSum(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);

        int max = Integer.MIN_VALUE;
        int rsp = 0, index = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode node = stack.poll();
                sum += node.val;
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
            if (sum > max) {
                max = sum;
                rsp = index;
            }
            index++;
        }
        return rsp;
    }
}
