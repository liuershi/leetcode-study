package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/1/17 9:33 下午
 * @Version 1.0
 */
public class Demo1814 {

    public int countNicePairs(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int reverse = reverse(num);
            int diff = num - reverse;
            Integer cnt = map.getOrDefault(diff, 0);
            res = (res + cnt) % MOD;
            map.merge(diff, 1, Integer::sum);
        }
        return res;
    }

    public int reverse(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Demo1814 demo1814 = new Demo1814();
        int[] nums = {13,10,35,24,76};
        System.out.println(demo1814.countNicePairs(nums));
    }

}
