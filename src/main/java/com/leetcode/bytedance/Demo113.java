package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 21:09
 */
public class Demo113 {

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

    List<List<Integer>> rsp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return rsp;

        dfs(root, 0, targetSum, new LinkedList<Integer>());

        return rsp;
    }

    private void dfs(TreeNode node, int currentSum, int targetSum, LinkedList<Integer> path) {
        if (node == null) return;
        currentSum += node.val;
        path.addLast(node.val);
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum)
                rsp.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        dfs(node.left, currentSum, targetSum, path);
        dfs(node.right, currentSum, targetSum, path);
        path.removeLast();
    }
}
