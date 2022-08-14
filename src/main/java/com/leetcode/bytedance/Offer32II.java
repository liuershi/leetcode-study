package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/14 10:34 下午
 * @Version 1.0
 */
public class Offer32II {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> curRow = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                curRow.add(node.val);
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
            res.add(curRow);
        }
        return res;
    }
}
