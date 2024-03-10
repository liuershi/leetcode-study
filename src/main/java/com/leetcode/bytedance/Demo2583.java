package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2024/2/23 12:21 上午
 * @Version 1.0
 */
public class Demo2583 {

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

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
            queue.offer(sum);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        if (queue.size() < k) {
            return -1;
        }
        return queue.poll();
    }


    public long kthLargestLevelSumTwo(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        // 存储每层结果
        List<Long> result = new ArrayList<>();

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
            result.add(sum);
        }

        if (result.size() < k) {
            return -1;
        }
        // 排序每层节点值和
        Collections.sort(result);
        return result.get(result.size() - k);
    }
}
