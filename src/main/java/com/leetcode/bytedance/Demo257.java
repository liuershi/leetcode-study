package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/15 11:45 下午
 * @Version 1.0
 */
public class Demo257 {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rsp = new ArrayList<>();
        if (root == null) return rsp;
        dfs(rsp, root, new LinkedList<>());
        return rsp;
    }

    private void dfs(List<String> rsp, TreeNode node, LinkedList<String> path) {
        if (node == null) return;
        path.addLast(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            rsp.add(String.join("->", path));
        }
        dfs(rsp, node.left, path);
        dfs(rsp, node.right, path);
        path.removeLast();
    }
}
