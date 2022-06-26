package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/26 3:42 下午
 * @Version 1.0
 */
public class Demo572 {
    
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

    boolean rsp;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root, subRoot);
        return rsp;
    }

    private void dfs(TreeNode node, TreeNode subRoot) {
        if (node == null || rsp) return;
        if (node.val == subRoot.val && (rsp = check(node, subRoot))) {
            return;
        }
        dfs(node.left, subRoot);
        dfs(node.right, subRoot);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return check(node1.left, node2.left) && check(node1.right, node2.right);
    }
}
