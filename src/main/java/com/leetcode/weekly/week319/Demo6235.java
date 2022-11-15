package com.leetcode.weekly.week319;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/11/13 11:01 上午
 * @Version 1.0
 */
public class Demo6235 {
    
    public static class TreeNode {
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

    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);

        int rsp = 0;
        while (!stack.isEmpty()) {
            // 先判断栈内元素是否需要排序
            int[] arr = stack.stream().map(node -> node.val).mapToInt(Integer::intValue).toArray();

            // 处理排序交换的次数
            rsp += minSwaps(arr);

            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
            }
        }

        return rsp;
    }

    /**
     * 使 arr 有序的最小交换次数
     * @param arr
     * @return
     */
    private int minSwaps(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> memo = new HashMap<>(len);
        for (int i = 0; i < arr.length; i++) {
            // 原数组的每个元素和其索引建立映射
            memo.put(arr[i], i);
        }
        Arrays.sort(arr);
        // 记录环的个数
        int loops = 0;
        // 标志每个元素是否被访问过
        boolean[] visitor = new boolean[len];
        for (int i = 0; i < len; i++) {
            // 没被访问过
            if (!visitor[i]) {
                int j = i;
                // visitor [i] 为 true 时，回到起点，找到一个环
                while (!visitor[i]) {
                    j = memo.get(arr[j]);
                    visitor[j] = true;
                }
                loops++;
            }
        }
        return len - loops;
    }

    public static void main(String[] args) {
        Demo6235 demo6235 = new Demo6235();
//        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(7), new TreeNode(6)), new TreeNode(2, new TreeNode(5), new TreeNode(4)));
//        System.out.println(demo6235.minimumOperations(root));

        int[] nums = {5,2,3,4};
        System.out.println(demo6235.minSwaps(nums));
    }
}
