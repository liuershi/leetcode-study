package com.leetcode.zcy;

import java.util.Arrays;

/**
 * leetcode 322
 *
 * @Author milindeyu
 * @Date 2022/5/1 12:04 上午
 * @Version 1.0
 */
public class Demo26 {

    public static int combinationMoney(int[] nums, int money) {
        int[] cache = new int[money + 1];
        Arrays.fill(cache, -2);
        return process(nums, money, cache);
    }

    private static int process(int[] nums, int money, int[] cache) {
        if (money <= 0) {
            return money == 0 ? 0 : -1;
        }
        if (cache[money] != -2) {
            return cache[money];
        }

        int rsp = Integer.MAX_VALUE;
        for (int num : nums) {
            int process = process(nums, money - num, cache);
            if (process == -1) {
                continue;
            }
            rsp = Math.min(process + 1, rsp);
        }
        int result = rsp == Integer.MAX_VALUE ? -1 : rsp;
        cache[money] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(combinationMoney(nums, 7));
    }
}
