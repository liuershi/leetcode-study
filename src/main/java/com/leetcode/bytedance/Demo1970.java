package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/19 12:18 上午
 * @Version 1.0
 */
public class Demo1970 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.merge(edge[0], edge[1]);
        }
        return unionFind.isConnected(source, destination);
    }

    class UnionFind {

        int size;
        int[] parent;
        int[] weight;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            this.weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int val)  {
            while (val != parent[val]) {
                parent[val] = parent[parent[val]];
                val = parent[val];
            }
            return val;
        }

        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        public void merge(int firstElement, int secondElement) {
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
}
