package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/25 5:28 下午
 * @Version 1.0
 */
public class Demo563 {
    
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

    public int findTilt(TreeNode root) {
       if (root == null) return 0;
       return dfs(root)[1];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        if (node.left == null && node.right == null) return new int[]{node.val, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int val = left[0] + right[0] + node.val;
        int abs = Math.abs(left[0] - right[0]) + left[1] + right[1];
        return new int[]{val, abs};
    }
}
