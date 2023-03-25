package com.leetcode.weekly.week336;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/3/12 10:48 上午
 * @Version 1.0
 */
public class Demo6317 {

    public static long beautifulSubarrays(int[] nums) {
        return method1(nums);
//        return method2(nums);
    }

    private static int method2(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    if (nums[i] == 0) {
                        count++;
                    }
                } else if (valid(nums, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean valid(int[] nums, int begin, int end) {
        int val = 0;
        for (int i = begin; i <= end; i++) {
            val ^= nums[i];
        }
        return val == 0;
    }

    private static long method1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] prefix = new int[n + 1];
        long count = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i - 1];
            count += map.getOrDefault(prefix[i], 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,1,2,4};
        System.out.println(beautifulSubarrays(nums));
    }
}
