package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/16 10:40 下午
 * @Version 1.0
 */
public class Offer26 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        return a.val == b.val && dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
