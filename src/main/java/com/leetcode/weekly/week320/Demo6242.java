package com.leetcode.weekly.week320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/11/20 10:37 上午
 * @Version 1.0
 */
public class Demo6242 {

    
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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
          List<List<Integer>> rsp = new ArrayList<>();
          if (root == null)
              return rsp;
          TreeSet<Integer> memo = new TreeSet<>();
          dfs(root, memo);
        for (Integer val : queries) {
            Integer ceiling = memo.ceiling(val);
            Integer floor = memo.floor(val);
            rsp.add(Arrays.asList(floor == null ? -1 : floor, ceiling == null ? -1 : ceiling));
        }
        return rsp;
    }

    private void dfs(TreeNode node, TreeSet<Integer> memo) {
        if (node == null) return;
        memo.add(node.val);
        dfs(node.left, memo);
        dfs(node.right, memo);
    }
}
