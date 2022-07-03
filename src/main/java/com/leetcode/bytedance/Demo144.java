package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 21:17
 */
public class Demo144 {

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

    /**
     * 基于迭代的方式，与递归的区别在于，其显式维护了栈的调用，而递归是隐式维护了栈的调用，它们的时间和空间复杂度相同
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        List<Integer> rsp = new ArrayList<>();
        if (root == null) return rsp;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                rsp.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return rsp;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rsp = new ArrayList<>();
        dfs(root, rsp);
        return rsp;
    }

    private void dfs(TreeNode node, List<Integer> rsp) {
        if (node == null) return;
        rsp.add(node.val);
        dfs(node.left, rsp);
        dfs(node.right, rsp);
    }
}
