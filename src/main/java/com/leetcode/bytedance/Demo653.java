package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/4/6 10:42 下午
 * @Version 1.0
 */
public class Demo653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Set<Integer> set = new HashSet<>();
    private boolean result;

    public boolean findTarget(TreeNode node, int k) {
        process(node, k);
        return result;
    }

    private void process(TreeNode node, int target) {
        if (node == null || result) return;

        if (set.contains(target - node.val)) {
            result = true;
            return;
        }
        set.add(node.val);
        process(node.left, target);
        process(node.right, target);
    }
}
