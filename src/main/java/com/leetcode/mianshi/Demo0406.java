package com.leetcode.mianshi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/5/16 10:09 下午
 * @Version 1.0
 */
public class Demo0406 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Deque<TreeNode> stack = new ArrayDeque<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null ) return null;
        if (root.val < p.val) {
            return inorderSuccessor(root.right, p);
        }
        return inorderSuccessorTwo(root.left, p);
    }

    public TreeNode inorderSuccessorTwo(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        process(root, p);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            if (stack.peek().val == p.val) {
                return prev;
            }
            prev = stack.poll();
        }
        return null;
    }

    private void process(TreeNode root, TreeNode p) {
        if (root == null) return;

        process(root.left, p);
        stack.push(root);
        process(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        TreeNode p = new TreeNode(6);

        Demo0406 demo0406 = new Demo0406();
        System.out.println(demo0406.inorderSuccessorTwo(root, p));
    }
}
