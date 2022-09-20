package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/9 12:16 上午
 * @Version 1.0
 */
public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int middle = left;
        // 后续遍历中，最右边的值为根节点的值
        int root = postorder[right];
        // 找到第一个大于根节点的值，该节点以及右边的节点值都所属右子树
        while (postorder[middle] < root) middle++;
        // 遍历当前节点右边的所有节点值，如果存在某个节点值小于根结点值则不可能构成搜索二叉树
        // 直接返回false
        int temp = middle + 1;
        while (temp < right) {
            if (postorder[temp++] < root) return false;
        }
        // 分别遍历左右子树
        // 注意：遍历右子树时需要将根节点排除，即只遍历到 right - 1
        return helper(postorder, left, middle - 1) && helper(postorder, middle, right - 1);
    }
}
