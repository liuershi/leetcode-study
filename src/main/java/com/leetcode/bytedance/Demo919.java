package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/7/25 10:24 下午
 * @Version 1.0
 */
public class Demo919 {

    class CBTInserter {

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

        Queue<TreeNode> container;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            container = new ArrayDeque<>();
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<>();
            // 使用宽度优先遍历将倒数第二层的右边叶子节点和倒数第一层左边的叶子节点查出来
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                // 当前节点存在左或右节点为空时则为叶子节点
                if (node.left == null || node.right == null) container.offer(node);
            }
        }

        public int insert(int val) {
            TreeNode parentNode = container.peek();
            TreeNode node = new TreeNode(val);
            if (parentNode.left == null) parentNode.left = node;
            else {
                parentNode.right = node;
                // 右节点也赋值时则当前父节点满了，移除父节点
                container.poll();
            }
            container.offer(node);
            return parentNode.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.numberOfLeadingZeros(1 << 16));
    }
}
