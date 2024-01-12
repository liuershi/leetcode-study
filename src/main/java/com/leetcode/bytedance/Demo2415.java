package com.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2023/12/15 9:22 下午
 * @Version 1.0
 */
public class Demo2415 {

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

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int level = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            if ((level & 1) == 1) {
                for (int i = 0; i < size >> 1; i++) {
                    TreeNode left = nodes.get(i);
                    TreeNode right = nodes.get(size - i - 1);
                    int val = left.val;
                    left.val = right.val;
                    right.val = val;
                }
            }

            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }

            level++;
        }

        return root;
    }
}
