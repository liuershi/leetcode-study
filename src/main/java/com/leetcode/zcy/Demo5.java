package com.leetcode.zcy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 * @Author milindeyu
 * @Date 2022/3/27 7:23 下午
 * @Version 1.0
 */
public class Demo5 {

    /**
     * 判断一个树是否为满二叉树
     *
     * 方式一：
     *      先求出树的高度L，同时计算所有节点数sum，是否满足1 << L - 1 == sum
     * @return
     */
    public static boolean isFullBT(TreeNode root) {
        if (root == null) return true;

        int l = 0;
        TreeNode cur = root;
        while (cur != null) {
            ++l;
            cur = cur.left;
        }

        int sum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
                ++sum;
            }
            if (root.right != null) {
                queue.add(root.right);
                ++sum;
            }
        }
        return ((1 << l) - 1) == sum;
    }


    /**
     * 方式二：
     *      使用递归方式（一种套路，所有关于二叉树的问题都可以通过此方式解决）
     * @param root
     * @return
     */
    public static boolean isFBT(TreeNode root) {
        if (root == null) return true;

        Info info = process(root);
        return info.nodes == ((1 << info.height) - 1);
    }

    private static Info process(TreeNode node) {
        if (node == null) return new Info(0, 0);

        int height;
        int nodes;

        Info left = process(node.left);
        Info right = process(node.right);
        height = Math.max(left.height, right.height) + 1;
        nodes = left.nodes + right.nodes + 1;

        return new Info(height, nodes);
    }

    static class Info {
        // 树的高度
        private int height;
        // 节点个数
        private int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }





    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(isFullBT(node));
        System.out.println(isFBT(node));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
