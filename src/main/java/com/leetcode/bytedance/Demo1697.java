package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author milindeyu
 * @Date 2022/12/14 11:29 下午
 * @Version 1.0
 */
public class Demo1697 {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 思路：离线算法 + 并查集
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        int len = queries.length;
        // 记录queries各元素的下标，根据queries对下标排序
        Integer[] indexs = new Integer[len];
        for (int i = 0; i < len; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs, Comparator.comparingInt(a -> queries[a][2]));

        UnionFind unionFind = new UnionFind(n);

        int k = 0;
        boolean[] res = new boolean[len];
        for (Integer index : indexs) {
            while (k < edgeList.length && edgeList[k][2] < queries[index][2]) {
                unionFind.unionElement(edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[index] = unionFind.isConnected(queries[index][0], queries[index][1]);
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        // 使用基于重量的路径压缩优化
        int[] weight;
        int size;

        public UnionFind(int size) {
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
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        public void unionElement(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);

            if (firstRoot == secondRoot)
                return;

            if (weight[firstRoot] > weight[secondRoot]) {
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
            } else {
                parent[firstRoot] = secondRoot;
                weight[secondRoot] += weight[firstRoot];
            }
        }
    }

    public static void main(String[] args) {
        Demo1697 demo1697 = new Demo1697();
        int[][] edgeList = {{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
        int[][] queries = {{0,4,14},{1,4,13}};
        demo1697.distanceLimitedPathsExist(5, edgeList, queries);
    }
}
