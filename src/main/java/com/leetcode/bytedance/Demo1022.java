package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/30 12:11 上午
 * @Version 1.0
 */
public class Demo1022 {

    
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

    int rsp = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return rsp;

        List<String> paths = new ArrayList<>();
        traceBack(root, new LinkedList<>(), paths);
        for (String path : paths) {
            rsp += Integer.parseInt(path, 2);
        }
        return rsp;
    }

    private void traceBack(TreeNode node, LinkedList<String> path, List<String> paths) {
        if (node == null) {
            paths.add(String.join("", path));
            return;
        }

        path.addLast(String.valueOf(node.val));
        traceBack(node.left, path, paths);
        traceBack(node.right, path, paths);
        path.removeLast();
    }
}
