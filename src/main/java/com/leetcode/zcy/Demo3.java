package com.leetcode.zcy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 树的先序、中序、后序打印
 *
 * @Author milindeyu
 * @Date 2022/3/27 12:42 上午
 * @Version 1.0
 */
public class Demo3 {

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
     * 先序打印
     * @param node
     */
    public static void beforeOrderPrint(Node node) {
        if (node == null) return;

        System.out.println(node.val);
        beforeOrderPrint(node.left);
        beforeOrderPrint(node.right);
    }

    /**
     * 基于栈的先序遍历
     * @param node
     */
    public static void beforeOrderPrintByStack(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }

    /**
     * 中序打印
     * @param node
     */
    public static void currentOrderPrint(Node node) {
        if (node == null) return;

        currentOrderPrint(node.left);
        System.out.println(node.val);
        currentOrderPrint(node.right);
    }

    /**
     * 基于栈的中序遍历
     * @param node
     */
    public static void currentOrderPrintByStack(Node node) {
        Deque<Node> stack = new ArrayDeque<>();
        if (node != null) {
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.println(node.val);
                    node = node.right;
                }
            }
        }
    }



    /**
     * 后序打印
     * @param node
     */
    public static void afterOrderPrint(Node node) {
        if (node == null) return;

        afterOrderPrint(node.left);
        afterOrderPrint(node.right);
        System.out.println(node.val);
    }

    /**
     * 基于栈的后序遍历
     * @param node
     */
    public static void afterOrderPrintByStack(Node node) {
        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();

        stack1.push(node);
        while (!stack1.isEmpty()) {

            Node pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) stack1.push(pop.left);
            if (pop.right != null) stack1.push(pop.right);
        }
        while (!stack2.isEmpty()) System.out.println(stack2.pop().val);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println("=================before=================");
        beforeOrderPrint(node);
        System.out.println("=================before=================");
        System.out.println("=================current=================");
        currentOrderPrint(node);
        System.out.println("=================current=================");
        System.out.println("=================after=================");
        afterOrderPrint(node);
        System.out.println("=================after=================");


        System.out.println("=======================================");
        beforeOrderPrintByStack(node);
        System.out.println("=======================================");
        currentOrderPrintByStack(node);
        System.out.println("=======================================");
        afterOrderPrintByStack(node);
    }
}
