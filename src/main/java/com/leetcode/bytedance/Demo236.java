package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/14 10:56 下午
 * @Version 1.0
 */
public class Demo236 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean pAdd;
    boolean qAdd;
    LinkedList<TreeNode> pPath = new LinkedList<>();
    LinkedList<TreeNode> qPath = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        dfs(root, p, q);

        // 二分的方式查询
        int len = Math.min(pPath.size(), qPath.size());
        int left = 0, right = len - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (qPath.get(middle).val != pPath.get(middle).val) {
                if (middle - 1 >= 0 && pPath.get(middle - 1).val == qPath.get(middle - 1).val)
                    return pPath.get(middle - 1);
                right = left - 1;
            } else {
                if (middle == len - 1 || (middle + 1 < len && pPath.get(middle + 1).val != qPath.get(middle + 1).val))
                    return pPath.get(middle);
                left = right + 1;
            }
        }

        // 自顶向下的遍历方式，前缀相同很长时较慢
        /*while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pNode = pPath.poll();
            TreeNode qNode = qPath.poll();
            if (pNode.val != qNode.val) break;
            rsp = pNode;
        }*/
        return pPath.get(left);
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || (pAdd && qAdd)) return;
        if (!pAdd)
            pPath.addLast(node);
        if (!qAdd)
            qPath.addLast(node);
        if (node.val == p.val) {
            pAdd = true;
        }
        if (node.val == q.val) {
            qAdd = true;
        }
        dfs(node.left, p, q);
        dfs(node.right, p, q);
        if (!pAdd)
            pPath.removeLast();
        if (!qAdd)
            qPath.removeLast();
    }



    // =============================
    // =============================
    // 基于后序遍历的的方式实现
    TreeNode rsp, p, q;
    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        helper(root);
        return rsp;
    }

    private boolean helper(TreeNode node) {
        if (node == null || rsp != null) return false;
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if (!left && !right) return node.val == p.val || node.val == q.val;
        else if (!left || !right) {
            if (node.val == p.val || node.val == q.val) rsp = node;
        } else rsp = node;
        return true;
    }


    // =============================
    // =============================
    // 基于哈希表存储父子节点关系实现
    Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
    Set<Integer> visitor = new HashSet<>();
    public TreeNode lowestCommonAncestorThree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    nodeParentMap.put(node.left, node);
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    nodeParentMap.put(node.right, node);
                    stack.offer(node.right);
                }
            }
        }

        do {
            visitor.add(p.val);
        } while ((p = nodeParentMap.get(p)) != null);
        while (!visitor.contains(q.val)) q = nodeParentMap.get(q);
        return q;
    }

}
