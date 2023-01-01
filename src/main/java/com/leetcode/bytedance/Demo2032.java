package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/12/29 6:32 下午
 * @Version 1.0
 */
public class Demo2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] memo = new int[101];
        for (int val : nums1) {
            memo[val] = 1;
        }
        for (int val : nums2) {
            memo[val] |= 2;
        }
        for (int val : nums3) {
            if (memo[val] == 1 || memo[val] == 2)
                memo[val] = 3;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 3) {
                res.add(i);
            }
        }
        return res;
    }
}
