package com.leetcode.bytedance;

import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2022/7/3 10:46 下午
 * @Version 1.0
 */
public class Demo496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = -1;
        int len2 = nums2.length, len1 = nums1.length;
        for (int i = len2 - 1; i >= 0; i--) {
            int val = nums2[i];
            if (val > max) {
                max = val;
                map.put(val, -1);
                continue;
            }
            int prev = nums2[i + 1];
            while (prev != -1 && prev < val) {
                prev = map.get(prev);
            }
            map.put(val, prev);
        }
        int[] rsp = new int[len1];
        for (int i = 0; i < len1; i++) {
            rsp[i] = map.get(nums1[i]);
        }
        return rsp;
    }
}
