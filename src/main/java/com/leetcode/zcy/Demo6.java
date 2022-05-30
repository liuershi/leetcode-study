package com.leetcode.zcy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/3/27 10:09 下午
 * @Version 1.0
 */
public class Demo6 {

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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    /**
     * 求节点o1、o2的最低公共父节点
     *
     *                   1
     *                /   \
     *               2     3
     *              / \   / \
     *            4    5 6   7
     *
     *            例：节点4和5的最低公共父节点为节点2；
     *                节点4和7的最低公共父节点为节点1
     *
     *      前提保障：o1、o2都在root节点树中
     * @param root
     * @param o1
     * @param o2
     */
    public static Node lowCommonNode(Node root, Node o1, Node o2) {
        if (o1 == null || o2 == null) return null;

        // 存储每个节点和其父节点的映射
        Map<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(root, root); // 头节点的父节点为其本身
        process(root, fatherMap);

        // o1节点向上回溯，保存其到头节点的链路
        Set<Node> o1Linked = new HashSet<>();
        while (o1 != fatherMap.get(o1)) { // 跳出循环时的条件为遍历到头节点
            o1Linked.add(o1);
            o1 = fatherMap.get(o1);
        }
        o1Linked.add(root);

        // 使o2向上回溯到头节点，在o1链路中直至找到公共节点
        while (o2 != fatherMap.get(o2)) {
            if (o1Linked.contains(o2)) {
                return o2;
            }
            o2 = fatherMap.get(o2);
        }
        return root;
    }

    private static void process(Node root, Map<Node, Node> fatherMap) {
        if (root == null) return;

        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);
        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2), new Node(3));
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(6);
        System.out.println(lowCommonNode(node, node.left.left, node.left.right));
    }
}
