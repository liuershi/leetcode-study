package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/26 4:43 下午
 * @Version 1.0
 */
public class Demo617 {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        root1.val = root1.val + root2.val;
        dfsMergeTree(root1.left, root2.left, root1, true);
        dfsMergeTree(root1.right, root2.right, root1, false);
        return root1;
    }

    private void dfsMergeTree(TreeNode root1, TreeNode root2, TreeNode prev, boolean isLeft) {
        if (root1 == null && root2 == null) return;
        if (root1 == null || root2 == null) {
            TreeNode node = root1 == null ? root2 : root1;
            if (isLeft) prev.left = node;
            else prev.right = node;
            return;
        }
        root1.val = root1.val + root2.val;
        dfsMergeTree(root1.left, root2.left, root1, true);
        dfsMergeTree(root1.right, root2.right, root1, false);
    }
}
