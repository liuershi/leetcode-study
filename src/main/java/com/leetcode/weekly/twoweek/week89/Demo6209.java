package com.leetcode.weekly.twoweek.week89;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/10/15 10:49 下午
 * @Version 1.0
 */
public class Demo6209 {

    public static int[] productQueries(int n, int[][] queries) {
//        return method1(n, queries);

        // 方式二
        List<Integer> powers = new ArrayList<>();
        while (n != 0) {
            int lowBit = n & -n;
            powers.add(lowBit);
            n ^= lowBit;
        }
        int divide = (int) 1e9 + 7;
        int[] rsp = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long mulity = powers.get(queries[i][0]);
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                mulity *= powers.get(j);
                mulity %= divide;
            }
            rsp[i] = (int) mulity;
        }
        return rsp;
    }

    private static int[] method1(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int num = n;
        while (num != 0) {
            powers.add(0, Integer.highestOneBit(num));
            num -= Integer.highestOneBit(num);
        }
        int divide = (int) (Math.pow(10, 9) + 7);
        int[] rsp = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long mulity = powers.get(queries[i][0]);
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                mulity *= powers.get(j);
                mulity %= divide;
            }
            rsp[i] = (int) mulity;
        }
        return rsp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-17));
        System.out.println(Integer.toBinaryString(17));
    }
}
