package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2022/6/19 12:21 上午
 * @Version 1.0
 */
public class Demo508 {
    
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

    // 节点数相同的最大值
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        // 存储节点和与该节点和个数的映射
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        return map.entrySet().stream().filter(entry -> max == entry.getValue()).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;
        int left = dfs(node.left, map);
        int right = dfs(node.right, map);
        // 后序遍历来自下而上的计算节点和
        int value = left + right + node.val;
        map.put(value, map.getOrDefault(value, 0) + 1);
        max = Math.max(max, map.get(value));
        return value;
    }
}
