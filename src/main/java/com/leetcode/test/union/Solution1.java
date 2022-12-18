package com.leetcode.test.union;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=1213
 *
 * @Author milindeyu
 * @Date 2022/12/14 11:15 下午
 * @Version 1.0
 */
public class Solution1 {

    /**
     * 题目：N个人要坐在桌子上吃饭，但是人们拒绝和陌生人坐在一张桌子上。什么样的不算陌生人呢？主要是朋友的朋友的朋友的.....只要能扯上关系就不算陌生人。能扯上关系就可以坐在一张桌子上。所以至少要准备多少张桌子？
     */

    static class UnionFind {
        int[] parent;
        int[] weight;
        // 元素个数
        int size;
        // 小组个数
        int groups;

        public UnionFind(int size) {
            this.size = size;
            // 初始化的时候每个人单独一个小组
            this.groups = size;
            this.parent = new int[size];
            this.weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int element) {
            // 使用路径压缩
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
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

            // 已经同一个组了就无须处理了
            if (firstElem == secondElem) {
                return;
            }

            if (weight[firstRoot] > weight[secondRoot]) {
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
            } else {
                parent[firstElem] = secondRoot;
                weight[secondRoot] += weight[firstRoot];
            }
        }


        public int getGroups() {
            return this.groups;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int size = scanner.nextInt();
            UnionFind union = new UnionFind(size);
            int input = scanner.nextInt();
            for (int j = 0; j < input; j++) {
                //因为测试数据是从1开始，而我们的并查集是从数组的第0位开始
                int first = scanner.nextInt() - 1;
                int second = scanner.nextInt() - 1;
                union.union(first, second);
            }
            System.out.println(union.getGroups());
        }
    }
}
