package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/6/26 11:42 下午
 * @Version 1.0
 */
public class Demo662 {

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


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int rsp = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.addLast(node.right);
                }
            }
            if (!queue.isEmpty()) {
                int maxWidth = Math.abs(queue.peekLast().val - queue.peekFirst().val) + 1;
                rsp = Math.max(rsp, maxWidth);
            }
        }
        return rsp;
    }
}
