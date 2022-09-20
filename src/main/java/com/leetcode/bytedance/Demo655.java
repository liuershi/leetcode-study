package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/8/22 10:47 下午
 * @Version 1.0
 */
public class Demo655 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int m, n, height;
    public List<List<String>> printTree(TreeNode root) {
        height = dfs(root) - 1;
        m = height + 1;
        n = (int) Math.pow(2, height + 1) - 1;
        String[][] res = new String[m][n];
        for (String[] strs : res) {
            Arrays.fill(strs, "");
        }
        res[0][(n - 1) / 2] = String.valueOf(root.val);
        dfsFill(res, root, null, 0, 0, true);
        return Arrays.stream(res).map(Arrays::asList).collect(Collectors.toList());
    }

    private void dfsFill(String[][] res, TreeNode node, TreeNode parentNode, int r, int c, boolean isLeft) {
        if (node == null) return;
        if (parentNode == null) {
            // 说明为根节点
            r = 0;
            c = (n - 1) / 2;
            res[r][c] = String.valueOf(node.val);
            dfsFill(res, node.left, node, r, c, true);
            dfsFill(res, node.right, node, r, c, false);
        } else {
            if (isLeft) {
                c -= Math.pow(2, height - r - 1);
            } else {
                c += Math.pow(2, height - r - 1);
            }
            r = r + 1;
            res[r][c] = String.valueOf(node.val);
            dfsFill(res, node.left, node, r, c, true);
            dfsFill(res, node.right, node, r, c, false);
        }
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
