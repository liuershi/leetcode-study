package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/6/2 22:32
 */
public class Demo450 {


    public static class TreeNode {
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


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        int val = root.val;
        if (key > val) {
            // 从右子树查
            root.right = deleteNode(root.right, key);
        } else if (key < val) {
            // 从左子树查
            root.left = deleteNode(root.left, key);
        } else {
            // 找到了需要删除的节点

            // 第一种情况：无右子树时
            if (root.right == null) return root.left;
            // 无左子树时
            else if (root.left == null) return root.right;
            else {
                // 有左右子树时
                // 查询出右子树的最左节点
                TreeNode right = root.right;
                while (right.left != null)
                    right = right.left;

                right.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
