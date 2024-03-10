package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2024/2/8 11:38 下午
 * @Version 1.0
 */
public class Demo2641 {

    public static class TreeNode {
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

    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode> container = new LinkedList<>();
        container.addLast(root);
        Map<TreeNode, Integer> nodeMapping = new HashMap<>();
        int sum = root.val, nextSum = 0;
        while (!container.isEmpty()) {
            int size = container.size();
            while (size-- > 0) {
                TreeNode node = container.removeFirst();
                if (node.left != null) {
                    nodeMapping.put(node.left, node.right == null ? 0 : node.right.val);
                    container.addLast(node.left);
                    nextSum += node.left.val;
                }
                if (node.right != null) {
                    nodeMapping.put(node.right, node.left == null ? 0 : node.left.val);
                    container.addLast(node.right);
                    nextSum += node.right.val;
                }

                Integer otherVal = nodeMapping.get(node);
                if (otherVal == null) {
                    node.val = sum - node.val;
                } else {
                    int val = otherVal + node.val;
                    node.val = sum - val;
                }
            }

            sum = nextSum;
            nextSum = 0;
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        Demo2641 demo2641 = new Demo2641();
        demo2641.replaceValueInTree(node);
    }
}
