package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/6/26 4:58 下午
 * @Version 1.0
 */
public class Demo623 {
    
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int curDepth = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.pop();
                if (curDepth == depth - 1) {
                    TreeNode left = node.left;
                    node.left = new TreeNode(val, left, null);
                    TreeNode right = node.right;
                    node.right = new TreeNode(val, null, right);
                }

                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
            if (++curDepth == depth) break;
        }
        return root;
    }
}
