package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/21 1:27 下午
 * @Version 1.0
 */
public class Demo102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (root == null) return rsp;

//        return method01(root);

        // 方法二：利用队列先进先出特性
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            rsp.add(list);
        }
        return rsp;
    }

    /**
     * 方法一：递归
     * @param root
     * @return
     */
    private ArrayList<List<Integer>> method01(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        process(map, 0, root);
        return new ArrayList<>(map.values());
    }

    private void process(Map<Integer, List<Integer>> map, int level, TreeNode root) {
        if (root == null) return;
        map.computeIfAbsent(level, k -> new ArrayList<>());
        map.get(level).add(root.val);
        ++level;
        process(map, level, root.left);
        process(map, level, root.right);
    }
}
