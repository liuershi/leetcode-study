package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/7/11 11:29 下午
 * @Version 1.0
 */
public class Demo108 {
    
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : builderTree(nums, 0, nums.length - 1);
    }

    private TreeNode builderTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = builderTree(nums, left, middle - 1);
        node.right = builderTree(nums, middle + 1, right);
        return node;
    }
}
