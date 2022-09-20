package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/8/31 11:24 下午
 * @Version 1.0
 */
public class Offer34 {

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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        traceback(root, res, new LinkedList<Integer>(), target, 0);
        return res;
    }

    private void traceback(TreeNode node, List<List<Integer>> res, LinkedList<Integer> path, int target, int sum) {
        if (node == null) return;
        path.addLast(node.val);
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum == target) res.add(new ArrayList<>(path));
            // 这里不能return，否则上面执行的 addLast() 方法新增的节点无法移除
        }
        traceback(node.left, res, path, target, sum);
        traceback(node.right, res, path, target, sum);
        path.removeLast();
    }
}
