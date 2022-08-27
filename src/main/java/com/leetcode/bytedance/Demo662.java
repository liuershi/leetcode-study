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
        // 思路：对于二叉树，每个节点值和其左右子节点的关系满足父节点节点值为n，
        // 则左子节点值为 n * 2 + 1，右子节点值为 n * 2 + 2，罗列每层的所有
        // 节点，根据第一和最后一个节点值的差求得每层的最大节点数
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int res = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    // 此时值需要根据父节点来设置
                    node.left.val = node.val * 2 + 1;
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    stack.offer(node.right);
                }
            }
            // 当此时有节点时求最大节点数
            if (!stack.isEmpty()) {
                res = Math.max(res, stack.peekLast().val - stack.peekFirst().val + 1);
            }
        }
        return res;
    }
}
