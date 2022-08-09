package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * @Author milindeyu
 * @Date 2022/7/30 3:24 下午
 * @Version 1.0
 */
public class Demo173 {

    class BSTIterator {

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

        TreeNode root;

        public BSTIterator(TreeNode root) {
            parseTree(root);
        }

        private void parseTree(TreeNode node) {
            if (node.right != null) parseTree(node.right);

            node.right = root;
            root = node;
            if (node.left != null) parseTree(node.left);
        }


        public int next() {
            int val = root.val;
            root = root.right;
            return val;
        }

        public boolean hasNext() {
            return root != null;
        }
    }
}
