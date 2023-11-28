package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/10/21 12:52 上午
 * @Version 1.0
 */
public class Demo2316 {

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] listNums = new ArrayList[n];
        Arrays.setAll(listNums, x -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            listNums[x].add(y);
            listNums[y].add(x);
        }

        boolean[] visitor = new boolean[n];
        long ans = 0;
        for (int i = 0, total = 0; i < n; i++) {
            if (!visitor[i]) {
                int size = dfs(i, listNums, visitor);
                ans += (long) size * total;
                total += size;
            }
        }
        return ans;
    }

    private int dfs(int i, List<Integer>[] listNums, boolean[] visitor) {
        visitor[i] = true;
        int size = 1;
        for (Integer num : listNums[i]) {
            if (!visitor[num]) {
                size += dfs(num, listNums, visitor);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Demo2316 demo2316 = new Demo2316();
        int[][] edges = {{5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}};
        int n = 11;
        System.out.println(demo2316.countPairs(n, edges));
    }
}
