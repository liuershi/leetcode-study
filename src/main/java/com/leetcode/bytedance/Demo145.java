package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhangwei151
 * @date 2022/6/5 21:38
 */
public class Demo145 {

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
     * 使用迭代替换递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        List<Integer> rsp = new ArrayList<>();
        if (root == null) return rsp;
        return rsp;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rsp = new ArrayList<>();
        dfs(root, rsp);
        return rsp;
    }

    private void dfs(TreeNode node, List<Integer> rsp) {
        if (node == null) return;
        dfs(node.left, rsp);
        dfs(node.right, rsp);
        rsp.add(node.val);
    }
}
