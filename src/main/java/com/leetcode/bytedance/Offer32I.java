package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/16 10:51 下午
 * @Version 1.0
 */
public class Offer32I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                res.add(node.val);
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
