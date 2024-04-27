package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2024/3/12 9:49 下午
 * @Version 1.0
 */
public class Demo1261 {

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

    class FindElements {

        Set<Integer> set;

        public FindElements(TreeNode root) {
            this.set = new HashSet<>();
            set.add(0);
            dfs(0, root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void dfs(int val, TreeNode node) {
            if (node == null) {
                return;
            }
            int left = 0, right = 0;
            if (node.left != null) {
                left = val * 2 + 1;
                set.add(left);
                dfs(left, node.left);
            }
            if (node.right != null) {
                right = val * 2 + 2;
                set.add(right);
                dfs(right, node.right);
            }
        }
    }
}
