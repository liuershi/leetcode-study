package com.leetcode.bytedance;

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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rsp = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // todo
            }
        }
        return rsp;
    }
}
