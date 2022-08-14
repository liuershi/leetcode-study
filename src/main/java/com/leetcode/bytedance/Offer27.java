package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 6:57 下午
 * @Version 1.0
 */
public class Offer27 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode node) {
        if (node == null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        reverse(left);
        reverse(right);
    }
}
