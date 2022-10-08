package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/advantage-shuffle/
 *
 * @Author milindeyu
 * @Date 2022/10/8 10:40 下午
 * @Version 1.0
 */
public class Demo870_1 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        Arrays.sort(nums1);
        Integer[] ids = IntStream.range(0, len).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, Comparator.comparingInt(i -> nums2[i]));
        int left = 0, right = len - 1;
        for (int val : nums1) {
            res[val > nums2[ids[left]] ? ids[left++] : ids[right--]] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        Demo870_1 demo = new Demo870_1();
        demo.advantageCount(nums1, nums2);
    }
}
