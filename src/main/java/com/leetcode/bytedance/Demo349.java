package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/17 9:48 下午
 * @Version 1.0
 */
public class Demo349 {

    public int[] intersection(int[] nums1, int[] nums2) {
//        return method01(nums1, nums2);

        // 基于哈希表来实现
        int len1 = nums1.length, len2 = nums2.length;
        Set<Integer> set1 = new HashSet<>(len1);
        Set<Integer> set2 = new HashSet<>(len2);
        for (int num : nums1) set1.add(num);
        for (int num : nums2) {
            if (set1.contains(num)) set2.add(num);
        }

        return set2.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] method01(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        if (nums1[len1 - 1] < nums2[0] || nums2[len2 - 1] < nums1[0]) return new int[]{};

        int len = Math.min(len1, len2);
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0, j = 0; i < len1 && j < len2;) {
            while (i > 0 && i < len1 && nums1[i] == nums1[i - 1]) i++;
            while (j > 0 && j < len2 && nums2[j] == nums2[j - 1]) j++;
            if (i == len1 || j == len2) break;
            int val1 = nums1[i], val2 = nums2[j];
            if (val1 == val2) {
                list.add(val1);
                i++;
                j++;
            } else if (val1 < val2) {
                i++;
            } else j++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
