package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/23 11:22 下午
 * @Version 1.0
 */
public class Demo547 {

    /*int[][] isConnected;
    int rsp, n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        this.isConnected = isConnected;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    rsp++;
                    isConnected[i][j] = 0;
                    infectedI(i, j);
                    infectedJ(j, i);
                    break;
                }
            }
        }
        return rsp;
    }

    private void infectedI(int i, int begin) {
        for (int j = begin; j < n; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                infectedJ(j, 0);
            }
        }
    }

    private void infectedJ(int j, int begin) {
        for (int i = begin; i < n; i++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                infectedI(i, 0);
            }
        }
    }*/


    /**
     * 使用并查集实现
     * @see https://leetcode.cn/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < n; i++) {
            unionFind.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.merge(i, j);
                }
            }
        }
        return unionFind.getProvinceSize();
    }

    /**
     * 并查集对象：模版代码
     */
    class UnionFind {
        // 记录父节点
        Map<Integer, Integer> father;
        // 省份数量
        private int provinceSize;

        public UnionFind() {
            this.father = new HashMap<>();
            this.provinceSize = 0;
        }

        /**
         * 添加新节点
         * @param x
         */
        public void add(int x) {
            // 节点不存在时则添加
            if (!father.containsKey(x)) {
                father.put(x, null);
                provinceSize++;
            }
        }

        /**
         * 合并两个节点
         * @param x
         * @param y
         */
        public void merge(int x, int y) {
            int xv = find(x), yv = find(y);
            if (xv != yv) {
                father.put(xv, yv);
                provinceSize--;
            }
        }

        /**
         * 查询节点的祖父节点
         * @param x
         * @return
         */
        private int find(int x) {
            int root = x;
            // 向上递归查询直到某个节点父节点为null时
            while (father.get(root) != null) root = father.get(root);

            // 压缩路径，将长度超过2的链表转换为长度为2的节点
            while (root != x) {
                Integer originFather = father.get(x);
                father.put(x, root);
                x = originFather;
            }
            return root;
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        private int getProvinceSize() {
            return provinceSize;
        }
    }
}
