package com.leetcode.test.union;

/**
 * @Author milindeyu
 * @Date 2022/12/14 10:14 下午
 * @Version 1.0
 */
public class Union2 {

    /**
     * 快速union，快速find，基于重量.
     */


    // 记录每个元素的父节点
    int[] parent;
    // 记录每个元素的权重，这个权重是该节点集合下的元素个数
    int[] weight;
    int size;

    public Union2(int size) {
        this.size = size;
        this.parent = new int[size];
        this.weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
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

        // 所属同一个集合时无需处理
        if (firstParent == secondParent)
            return;

        if (weight[firstParent] > weight[secondParent]) {
            parent[secondParent] = firstParent;
            weight[firstParent] += weight[secondParent];
        } else {
            parent[firstParent] = secondParent;
            weight[secondParent] += weight[firstParent];
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
        Union2 union = new Union2(n);

        System.out.println("初始parent：");
        union.printArr(union.parent);
        System.out.println("初始weight：");
        union.printArr(union.weight);

        System.out.println("连接了5 6 之后的parent：");
        union.union(5, 6);
        union.printArr(union.parent);
        System.out.println("连接了5 6 之后的weight：");
        union.printArr(union.weight);

        System.out.println("连接了1 2 之后的parent：");
        union.union(1, 2);
        union.printArr(union.parent);
        System.out.println("连接了1 2 之后的weight：");
        union.printArr(union.weight);

        System.out.println("连接了2 3 之后的parent：");
        union.union(2, 3);
        union.printArr(union.parent);
        System.out.println("连接了2 3 之后的weight：");
        union.printArr(union.weight);

        System.out.println("连接了1 4 之后的parent：");
        union.union(1, 4);
        union.printArr(union.parent);
        System.out.println("连接了1 4 之后的weight：");
        union.printArr(union.weight);

        System.out.println("连接了1 5 之后的parent：");
        union.union(1, 5);
        union.printArr(union.parent);
        System.out.println("连接了1 5 之后的weight：");
        union.printArr(union.weight);

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
