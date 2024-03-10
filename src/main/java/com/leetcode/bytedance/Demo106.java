package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2024/2/21 12:17 上午
 * @Version 1.0
 */
public class Demo106 {

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

    Map<Integer, Integer> container;
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postIdx = n - 1;
        this.container = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            container.put(inorder[i], i);
        }
        return builderTree(inorder, postorder, 0, n - 1);
    }

    private TreeNode builderTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int inorderRootIdx = container.get(postorder[postIdx]);
        TreeNode root = new TreeNode(postorder[postIdx]);

        postIdx--;
        root.left = builderTree(inorder, postorder, inorderLeft, inorderRootIdx - 1);
        root.right = builderTree(inorder, postorder, inorderRootIdx + 1, inorderRight);

        return root;
    }
}
