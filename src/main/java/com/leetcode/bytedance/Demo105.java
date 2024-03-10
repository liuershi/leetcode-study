package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2024/2/20 12:13 上午
 * @Version 1.0
 */
public class Demo105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        this.container = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            container.put(inorder[i], i);
        }

        return builderTree(preorder, inorder, 0, n - 1, 0 , n - 1);
    }

    private TreeNode builderTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        int preorderRoot = preorderLeft;
        int inorderRootIdx = container.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);

        int leftSubTrrSize = inorderRootIdx - inorderLeft;

        root.left = builderTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubTrrSize, inorderLeft, inorderRootIdx - 1);
        root.right = builderTree(preorder, inorder, preorderLeft + leftSubTrrSize + 1, preorderRight, inorderRootIdx + 1, inorderRight);

        return root;
    }
}
