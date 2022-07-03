package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/22 9:11 下午
 * @Version 1.0
 */
public class Demo501 {


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

    int max, base, len;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
//        return method1(root);
        if (root == null) return new int[]{};
        base = root.val;
        dfs(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        int current = node.val;
        dfs(node.left);
        if (base == current) {
            len++;
        } else {
            len = 1;
            base = current;
        }
        if (len > max) {
            max = len;
            list.clear();
            list.add(current);
        } else if (len == max) {
            list.add(current);
        }
        dfs(node.right);
    }

    /**
     * 宽度优先遍历
     * @param root
     * @return
     */
    private int[] method1(TreeNode root) {
        if (root == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSize = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                maxSize = Math.max(maxSize, map.get(node.val));
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        int finalMaxSize = maxSize;
        return map.entrySet().stream().filter(entry -> entry.getValue() == finalMaxSize)
                .map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }
}
