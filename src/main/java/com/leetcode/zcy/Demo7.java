package com.leetcode.zcy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/3/27 11:32 下午
 * @Version 1.0
 */
public class Demo7 {

    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void printLine(int n) {
        // 根据折叠次数n构建二叉树
        Node node = buildTree(n);
        curErgodic(node);
    }

    // 中序遍历即可
    public static void curErgodic(Node node) {
        if (node == null) return;
        curErgodic(node.left);
        System.out.print(node.val);
        curErgodic(node.right);
    }

    private static Node buildTree(int n) {
        --n;
        Node root = new Node("u");
        process(root, n);
        return root;
    }

    private static void process(Node node, int n) {
        if (n == 0) return;
        node.left = new Node("u");
        node.right = new Node("n");
        --n;
        process(node.left, n);
        process(node.right, n);
    }

    public static void main(String[] args) {
        printLine(10);
    }
}
