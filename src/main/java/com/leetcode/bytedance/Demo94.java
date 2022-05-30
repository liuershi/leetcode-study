package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/5/29 3:45 下午
 * @Version 1.0
 */
public class Demo94 {

    
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rsp = new ArrayList<>();
        if (root == null) return rsp;

        process(root, rsp);
        return rsp;
    }

    private void process(TreeNode node, List<Integer> rsp) {
        if (node == null) return;

        process(node.left, rsp);
        rsp.add(node.val);
        process(node.right, rsp);
    }
}
