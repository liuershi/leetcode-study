package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/26 10:54 下午
 * @Version 1.0
 */
public class Demo652 {

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

    Map<String, Integer> map;
    List<TreeNode> rsp = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return rsp;
        map = new HashMap<>();
        dfs(root);
        return rsp;
    }

    private String dfs(TreeNode node) {
        if (node == null) return "#";
        String str = node.val + "#" + dfs(node.left) + "#" + dfs(node.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2)
            rsp.add(node);
        return str;
    }
}
