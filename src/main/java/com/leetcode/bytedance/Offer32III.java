package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/15 11:05 下午
 * @Version 1.0
 */
public class Offer32III {
    
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
        int depth = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> rowList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                rowList.add(node.val);
               if (node.left != null) stack.offer(node.left);
               if (node.right != null) stack.offer(node.right);
            }
            if ((depth++ & 1) == 1) Collections.reverse(rowList);
            res.add(rowList);
        }
        return res;
    }
}
