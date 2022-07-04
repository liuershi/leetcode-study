package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/30 11:19 下午
 * @Version 1.0
 */
public class Demo437 {

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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return count(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    public int count(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == sum) count = 1;
        return count(node.left, sum - node.val)
                + count(node.right, sum - node.val)
                + count;
    }
}
