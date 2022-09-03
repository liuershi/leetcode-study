package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author milindeyu
 * @Date 2022/9/3 10:19 下午
 * @Version 1.0
 */
public class Demo646 {

    public int findLongestChain(int[][] pairs) {

        // 思路：动态规划，先排序数组，然后依次遍历数组，遍历到的当前数对判断能否和前面的
        // 的数对构成数对链，若可以则在前面数的基础上加1，否则向前查找，知道查找到满足的数对
        int n = pairs.length;
        int[] res = new int[n + 1];
        Arrays.fill(res, 1);
        // 排序比较器，先判断第1个数的大小，再判断第2个数的大小
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else return o1[0] - o2[0];
            }
        };
        Arrays.sort(pairs, comparator);
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > pairs[i - 1][1]) res[i] = res[i - 1] + 1;
            else {
                int index = i - 2;
                while (index >= 0) {
                    if (pairs[i][0] > pairs[index][1]) {
                        res[i] = res[index] + 1;
                        break;
                    }
                    index--;
                }
            }
        }
        return res[n];
    }
}
