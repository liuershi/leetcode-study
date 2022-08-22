package com.leetcode.weekly.google.week307;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/21 11:32 上午
 * @Version 1.0
 */
public class Demo6154 {
    
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


    public int amountOfTime(TreeNode root, int start) {
        // 思路：从开始节点开始，向子节点和父节点扩散，直到扩散完毕
        // 难点：如何向父节点扩散（解决：通过dfs先将每个节点和其父节点的映射关系保存）

        Map<Integer, TreeNode> subParentMap = new HashMap<>();
        subParentMap.put(root.val, root); // 根节点父节点为其本身
        dfs(subParentMap, root);

        TreeNode startParentNode = subParentMap.get(start);
        TreeNode startNode; // 当前开始扩散的起始节点
        if (startParentNode.val == start) {
            startNode = startParentNode;
        } else {
            startNode = startParentNode.left != null && startParentNode.left.val == start ? startParentNode.left : startParentNode.right;
        }
        // 记录已经访问过的节点值
        Set<Integer> visitor = new HashSet<>();
        visitor.add(start);
        List<TreeNode> spreadNodes = new ArrayList<>(); // 当前需要扩散的节点
        spreadNodes.add(startNode);

        int res = 0;
        while (!spreadNodes.isEmpty()) {
            List<TreeNode> processNodes = new ArrayList<>(spreadNodes);
            spreadNodes.clear();
            for (TreeNode node : processNodes) {
                // 感染父节点
                if (visitor.add(subParentMap.get(node.val).val)) spreadNodes.add(subParentMap.get(node.val));
                // 感染子节点
                if (node.left != null && visitor.add(node.left.val)) spreadNodes.add(node.left);
                if (node.right != null && visitor.add(node.right.val)) spreadNodes.add(node.right);
            }
            if (!processNodes.isEmpty()) res++;
        }
        return res;
    }

    /**
     * 深度优先遍历，存储每个节点和其父节点的关系
     * @param subParentMap 映射关系容器
     * @param node 当前节点
     */
    private void dfs(Map<Integer, TreeNode> subParentMap, TreeNode node) {
        if (node.left != null) {
            subParentMap.put(node.left.val, node);
            dfs(subParentMap, node.left);
        }
        if (node.right != null) {
            subParentMap.put(node.right.val, node);
            dfs(subParentMap, node.right);
        }
    }
}
