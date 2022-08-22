package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/22 11:27 下午
 * @Version 1.0
 */
public class Offer54 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int kthLargest(TreeNode root, int k) {
        // 思路：由于是二叉搜索树，所以树左小右大，而二叉树的中序遍历的方式是有序的
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(res.size() - k);
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
}
