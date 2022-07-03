package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/6 10:59 下午
 * @Version 1.0
 */
public class Demo124 {

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

    // 使用全局变量存放结果
    int rsp = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 前置判断
        if (root == null) return 0;
        dfs(root);
        return rsp;
    }

    /**
     * 深度优先遍历
     * @param node 当前遍历的节点
     * @return
     */
    private int dfs(TreeNode node) {
        // 递归结束条件
        if (node == null) return 0;
        // 取当前节点的左子树的最大正数值，若左子树左子树最大路径和小于0，则取0
        int left = Math.max(dfs(node.left), 0);
        // 取当前节点的右子树的最大正数值，若右子树左子树最大路径和小于0，则取0
        int right = Math.max(dfs(node.right), 0);
        // 计算当前节点的最大路径和，必须包含当前节点
        int max = node.val + left + right;
        // 取最大值
        rsp = Math.max(rsp, max);
        // 返回条件，由于是返回给父节点，所以必不可能存在当前节点和当前节点的左右节点，因为这样无法组件不重复路径
        // 所以取当前节点和其左右节点中最大节点值
        return node.val + Math.max(left, right);
    }


}
