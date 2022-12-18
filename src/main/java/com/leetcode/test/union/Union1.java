package com.leetcode.test.union;

/**
 * @Author milindeyu
 * @Date 2022/12/14 10:04 下午
 * @Version 1.0
 */
public class Union1 {

    /**
     * 目标：快速union，慢find
     */

    // 表示每个元素的父元素
    int[] parent;
    int size;

    public Union1(int size) {
        this.size = size;
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElem, int secondElem) {
        return find(firstElem) == find(secondElem);
    }

    public void union(int firstElem, int secondElem) {
        int firstParent = find(firstElem);
        int secondParent = find(secondElem);
        if (firstParent != secondParent) {
            parent[firstParent] = secondParent;
        }
    }

    public void printArr() {
        for (int val : parent) {
            System.out.print(val + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        Union1 union = new Union1(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接了5 6");
        union.union(5, 6);
        union.printArr();

        System.out.println("连接了1 2");
        union.union(1, 2);
        union.printArr();

        System.out.println("连接了2 3");
        union.union(2, 3);
        union.printArr();

        System.out.println("连接了1 4");
        union.union(1, 4);
        union.printArr();

        System.out.println("连接了1 5");
        union.union(1, 5);
        union.printArr();

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
