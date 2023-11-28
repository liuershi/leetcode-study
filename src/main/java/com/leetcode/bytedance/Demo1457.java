package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/11/25 1:53 上午
 * @Version 1.0
 */
public class Demo1457 {

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

    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] memo = new int[10];
        recursion(root, memo);
        return count;
    }

    private void recursion(TreeNode node, int[] memo) {
        if (node == null) {
            return;
        }
        memo[node.val]++;
        if (node.left == null && node.right == null) {
            if (checkPalindromic(memo)) {
                count++;
            }
        }
        recursion(node.left, memo);
        recursion(node.right, memo);
        memo[node.val]--;
    }

    /**
     * 判断起能否组成一个伪回文的前提
     * 1. 当回文长度为奇数时，其中数字数量为奇数各的数至多一个
     * 2. 为偶数时不能存在奇数个数字
     * @param memo
     * @return
     */
    private boolean checkPalindromic(int[] memo) {
        int sum = 0;
        int oddCount = 0;
        for (int i = 0; i < 10; i++) {
            int val = memo[i];
            sum += val;
            if ((val & 1) == 1) {
                oddCount++;
            }
        }

        // 数字总数为奇数时
        if ((sum & 1) == 1) {
            if (oddCount > 1) {
                return false;
            }
        } else {
            // 数字总数为偶数时
            if ((oddCount & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}
