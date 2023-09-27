package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2023/9/4 12:48 上午
 * @Version 1.0
 */
public class Demo449 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return postOrder(root, sb);
    }

    private String postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        if (sb.length() != 0) {
            sb.append("#");
        }
        sb.append(root.val);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] vals = data.split("#");
        Deque<Integer> deque = new ArrayDeque<>(vals.length);
        for (String val : vals) {
            deque.push(Integer.parseInt(val));
        }
        return construct(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(Deque<Integer> deque, int min, int max) {
        if (deque.isEmpty() || deque.peek() < min || deque.peek() > max) {
            return null;
        }
        TreeNode node = new TreeNode(deque.pop());
        node.right = construct(deque, node.val, max);
        node.left = construct(deque, min, node.val);
        return node;
    }

    public static void main(String[] args) {
        Demo449 demo449 = new Demo449();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = demo449.deserialize(demo449.serialize(root));
        System.out.println(node);
    }
}
