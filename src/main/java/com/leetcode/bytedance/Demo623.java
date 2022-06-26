package com.leetcode.bytedance;

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
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (curDepth == depth - 1) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val, left, null);
                    node.right = new TreeNode(val, null, right);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (curDepth == depth - 1) break;
            curDepth++;
        }
        return root;
    }
}
