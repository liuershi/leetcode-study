package com.leetcode.test.union;

/**
 * @Author milindeyu
 * @Date 2022/12/14 10:33 下午
 * @Version 1.0
 */
public class Union3 {

    /**
     * 快速union，快速find，基于高度(基于秩)
     */

    int[] parent;
    int[] height;
    int size;

    public Union3(int size) {
        this.size = size;
        this.parent = new int[size];
        this.height = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            height[i] = 1;
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
        int firstRoot = find(firstElem);
        int secondRoot = find(secondElem);

        if (height[firstRoot] > height[secondRoot]) {
            parent[secondRoot] = parent[firstRoot];
        } else if (height[firstRoot] < height[secondRoot]) {
            parent[firstRoot] = parent[secondRoot];
        } else {
            parent[firstRoot] = secondRoot;
            height[firstRoot]++;
        }
    }

    private void printArr(int[] arr){
        for(int p : arr){
            System.out.print(p+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        Union3 union = new Union3(n);

        System.out.println("初始parent：");
        union.printArr(union.parent);
        System.out.println("初始height：");
        union.printArr(union.height);

        System.out.println("连接了5 6 之后的parent：");
        union.union(5, 6);
        union.printArr(union.parent);
        System.out.println("连接了5 6 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 2 之后的parent：");
        union.union(1, 2);
        union.printArr(union.parent);
        System.out.println("连接了1 2 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了2 3 之后的parent：");
        union.union(2, 3);
        union.printArr(union.parent);
        System.out.println("连接了2 3 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 4 之后的parent：");
        union.union(1, 4);
        union.printArr(union.parent);
        System.out.println("连接了1 4 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 5 之后的parent：");
        union.union(1, 5);
        union.printArr(union.parent);
        System.out.println("连接了1 5 之后的height：");
        union.printArr(union.height);

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
