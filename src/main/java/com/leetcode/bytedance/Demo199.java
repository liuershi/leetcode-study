package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/3/20 11:33 下午
 * @Version 1.0
 */
public class Demo199 {

    List<Integer> rep = new ArrayList<>();
    Map<Integer, Boolean> map = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        searchMax(root, true, 1);
        return rep;
    }

    private void searchMax(TreeNode root, boolean add, int depth) {
        if (root == null) {
            return;
        }
        if (add) {
            rep.add(root.val);
            map.put(depth, true);
        }
        TreeNode right = root.right;
        searchMax(right, map.get(depth), ++depth);
        searchMax(root.left, map.get(depth) == null && right == null, ++depth);
    }

    static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);
        Demo199 demo199 = new Demo199();
        System.out.println(demo199.rightSideView(treeNode));
    }
}
