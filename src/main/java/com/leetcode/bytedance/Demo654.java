package com.leetcode.bytedance;

/**
 * 最大二叉树
 *
 * @Author milindeyu
 * @Date 2022/8/20 9:20 下午
 * @Version 1.0
 */
public class Demo654 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    private TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) return null;

        int maxIndex = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxTree(nums, left, maxIndex - 1);
        root.right = maxTree(nums, maxIndex + 1, right);
        return root;
    }

    /**
     * 查找指定范围内最大数的索引
     * @param nums 指定数组
     * @param left 左边界
     * @param right 右边界
     * @return
     */
    private int findMax(int[] nums, int left, int right) {
        int max = -1, index = -1;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            if (max == nums[i]) index = i;
        }
        return index;
    }
}
