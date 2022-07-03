package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/14 10:44 下午
 * @Version 1.0
 */
public class Demo235 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode rsp;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) return root;
        if (p.val < q.val)
            dfs(root, p, q);
        else
            dfs(root, q, p);
        return rsp;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || rsp != null) return;
        int val = node.val;
        if (q.val < val)
            dfs(node.left, p, q);
        else if (p.val > val)
            dfs(node.right, p, q);
        else
            rsp = node;
    }
}
