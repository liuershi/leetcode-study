package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/3/27 6:13 下午
 * @Version 1.0
 */
public class Demo98 {

    private long processVal = Long.MIN_VALUE;

    boolean rsp = true;

    public boolean isValidBST(TreeNode root) {
//        return method1(root);
        // 中序遍历为升序
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return rsp;
    }

    private void process(TreeNode node, List<Integer> list) {
        if (node == null || !rsp) return;
        if (!list.isEmpty() && list.get(list.size() - 1) > node.val) {
            rsp = false;
            return;
        }
        list.add(node.val);
        process(node.left, list);
        process(node.right, list);
    }

    private boolean method1(TreeNode root) {
        if (root == null) return true;

        boolean leftValid = isValidBST(root.left);
        if (!leftValid || root.val <= processVal) return false;
        processVal = root.val;
        return isValidBST(root.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
