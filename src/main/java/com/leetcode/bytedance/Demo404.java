package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/20 11:13 下午
 * @Version 1.0
 */
public class Demo404 {
    
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int rsp = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) rsp += root.left.val;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + rsp;
    }
}
