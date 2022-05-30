package com.leetcode.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/3/27 6:45 下午
 * @Version 1.0
 */
public class Demo958 {

    class TreeNode {
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

    /**
     * 判断当前二叉树是否为完全二叉树
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        // 使用宽度优先级遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果某个节点存在缺失左或右节点时
        boolean isLeaf = false;
        TreeNode l, r;
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;

            if (
                    // 如果遇到过某个节点存在缺失左或右节点，此时若当前节点不为叶节点时
                    (!isLeaf && (l != null || r != null))
                            ||
                            // 当前节点的左节点为空，右节点不为空
                            (l == null && r != null)
            )
                return false;

            if (l != null) queue.add(l);
            if (r != null) queue.add(r);

            if (l == null || r == null) isLeaf = true;
        }
        return true;
    }
}
