package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/9 1:10 上午
 * @Version 1.0
 */
public class Demo95 {

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


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rsp = new ArrayList<>();
        if (n == 0) return rsp;

        return process(1, n);
    }

    private List<TreeNode> process(int start, int end) {
        List<TreeNode> allNodes = new ArrayList<>();
        if (start > end) {
            allNodes.add(null);
            return allNodes;
        }
        if (start == end) {
            allNodes.add(new TreeNode(start));
            return allNodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = process(start, i - 1);
            List<TreeNode> rightNodes = process(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    allNodes.add(node);
                }
            }
        }
        return allNodes;
    }

    public static void main(String[] args) {
        Demo95 demo95 = new Demo95();
        demo95.generateTrees(3);
    }
}
