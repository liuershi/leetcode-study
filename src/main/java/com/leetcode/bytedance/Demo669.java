package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/12 10:18 下午
 * @Version 1.0
 */
public class Demo669 {
    
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

    public TreeNode trimBST(TreeNode node, int low, int high) {
        if (node == null) return null;
        if (node.val < low) return trimBST(node.right, low, high);
        if (node.val > high) return trimBST(node.left, low, high);
        TreeNode left = trimBST(node.left, low, high);
        TreeNode right = trimBST(node.right, low, high);
        node.left = left;
        node.right = right;
        return node;
    }
}
