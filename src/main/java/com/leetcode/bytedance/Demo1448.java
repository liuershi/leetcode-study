package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/8/25 12:22 上午
 * @Version 1.0
 */
public class Demo1448 {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int count;
    public int goodNodes(TreeNode root) {
        recursion(root, root.val);
        return count;
    }

    public int recursion(TreeNode node, int pathMax) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.val >= pathMax) {
            count++;
            pathMax = node.val;
        }
        recursion(node.left, pathMax);
        recursion(node.right, pathMax);
        return pathMax;
    }
}
