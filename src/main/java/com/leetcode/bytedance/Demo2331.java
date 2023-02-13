package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/6 12:06 上午
 * @Version 1.0
 */
public class Demo2331 {
    
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

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        return root.val == 2 ? evaluateTree(root.left) | evaluateTree(root.right) :
                evaluateTree(root.left) && evaluateTree(root.right);
    }
}
