package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/26 11:01 下午
 * @Version 1.0
 */
public class Demo701 {
    
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 思路：递归处理，若当前节点为空，则说明到了末尾，直接创建节点并返回
        // 时间复杂度和空间复杂度都为：O(n)
        // 空间复杂度在于调用调用的栈消耗
        if (root == null) return new TreeNode(val);
        // 递归调用，知道创建节点后返回
        TreeNode node = insertIntoBST(root.val < val ? root.right : root.left, val);
        // 判断创建的节点是作为当前节点的左子节点还是右子节点
        if (root.val > val) root.left = node;
        else root.right = node;
        return root;
    }
}
