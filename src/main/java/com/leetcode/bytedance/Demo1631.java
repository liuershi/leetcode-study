package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2023/12/11 12:23 上午
 * @Version 1.0
 */
public class Demo1631 {

    public int minimumEffortPath(int[][] heights) {
        // 思路：并查集
        // 并查集概念：https://www.cnblogs.com/noKing/p/8018609.html

        int row = heights.length, col = heights[0].length;
        // edges中的元素为： [边的权重，边的第一个顶点，边的第二个顶点] 三元组
        List<int[]> edges = new ArrayList<>(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int unique = i * col + j;
                if (i + 1 < row) {
                    edges.add(new int[]{
                            Math.abs(heights[i][j] - heights[i + 1][j]),
                            unique,
                            unique + col
                    });
                }

                if (j + 1 < col) {
                    edges.add(new int[]{
                            Math.abs(heights[i][j] - heights[i][j + 1]),
                            unique,
                            unique + 1
                    });
                }
            }
        }

        // 按耗费体力值从小达到的顺序排列
        edges.sort(Comparator.comparingInt(a -> a[0]));

        UnionFind unionFind = new UnionFind(row * col);
        for (int[] edge : edges) {
            // 合并边的两个点
            unionFind.union(edge[1], edge[2]);
            if (unionFind.connected(0, row * col - 1)) {
                return edge[0];
            }
        }
        return 0;
    }


    /**
     * 基于路径压缩和按秩的优化
     */
    static class UnionFind {
        // 每个节点的父节点
        int[] parent;
        // 每个节点的秩（即高度）
        int[] height;
        // 节点个数
        int size;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            this.height = new int[size];
            for (int i = 0; i < size; i++) {
                // 初始化时设置每个节点的父节点为自己
                parent[i] = i;
                // 初始化秩为1
                height[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int first, int second) {
            int firstRoot = find(first);
            int secondRoot = find(second);
            // 两个节点不属于同一集合时合并
            if (firstRoot != secondRoot) {
                if (height[firstRoot] > height[secondRoot]) {
                    parent[secondRoot] = firstRoot;
                } else if (height[firstRoot] < height[secondRoot]) {
                    parent[firstRoot] = parent[secondRoot];
                } else {
                    parent[firstRoot] = parent[secondRoot];
                    height[secondRoot]++;
                }
            }
        }

        public boolean connected(int first, int second) {
            return find(first) == find(second);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}};
        Demo1631 demo1631 = new Demo1631();
        System.out.println(demo1631.minimumEffortPath(matrix));
    }
}
