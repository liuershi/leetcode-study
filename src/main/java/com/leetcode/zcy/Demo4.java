package com.leetcode.zcy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2022/3/27 5:07 下午
 * @Version 1.0
 */
public class Demo4 {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 宽度优先级遍历
     * @param node
     */
    public static void widthPriorityTraversal(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    /**
     * 返回节点数最多一层的节点数
     * @param node
     * @return
     */
    public static int obtainDept(Node node) {
        if (node == null) return 0;

        // 对应节点与之对应的层级
        Map<Node, Integer> map = new HashMap<>();
        map.put(node, 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // 当初层级
        int curLevel = 1;
        // 当前层级节点数
        int curLevelNodes = 0;
        // 最大节点数
        int max = 0;
        while (!queue.isEmpty()) {
            node = queue.poll();
            // 当前统计的节点为当前层级
            if (curLevel == map.get(node)) {
                curLevelNodes++;
            } else {
                // 当前统计的节点在curLevel对应层级的下一层级了
                curLevelNodes = 1;
                ++curLevel;
            }
            max = Math.max(max, curLevelNodes);

            if (node.left != null){
                map.put(node.left, curLevel + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, curLevel + 1);
                queue.add(node.right);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(5);
        node.right.right = new Node(6);
        node.left.right.right = new Node(7);

        widthPriorityTraversal(node);
        System.out.println("++++++++++++++++");
        System.out.println(obtainDept(node));
    }
}
