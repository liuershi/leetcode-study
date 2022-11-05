package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/4 9:54 下午
 * @Version 1.0
 */
public class Demo754 {

    public static int reachNumber(int target) {
        int res = 0, sum = 0;
        while (sum < target || ((sum - target) & 1) == 1) sum += ++ res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(12131334));
    }
}
