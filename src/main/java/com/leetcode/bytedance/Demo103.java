package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/21 11:17 上午
 * @Version 1.0
 */
public class Demo103 {


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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (root == null) return rsp;

//        return method01(root, rsp);

        // 方法二：基于队列的方式
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            boolean isOdd = (level & 1) == 1; // 层级是否为奇数，奇数则从左到右，偶数从右到左
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (isOdd) {
                    list.addLast(current.val);
                } else {
                    list.addFirst(current.val);
                }
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            level++;
            rsp.add(list);
        }

        return rsp;
    }


    /**
     * 方法一：广度优先遍历（同102一样）
     * @param root
     * @param rsp
     * @return
     */
    private List<List<Integer>> method01(TreeNode root, List<List<Integer>> rsp) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        process(1, root, map);
        rsp.addAll(map.values());
        return rsp;
    }

    private void process(int level, TreeNode root, Map<Integer, LinkedList<Integer>> map) {
        if (root == null) return;
        // 奇数层从左向右；偶数层从右向左
        boolean isOdd = (level & 1) == 1;
        map.computeIfAbsent(level, k -> new LinkedList<>());
        if (isOdd) {
            map.get(level).addLast(root.val);
        } else {
            map.get(level).addFirst(root.val);
        }
        ++level;
        process(level, root.left, map);
        process(level, root.right, map);
    }
}
