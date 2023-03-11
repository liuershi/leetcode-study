package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author milindeyu
 * @Date 2023/2/27 9:23 下午
 * @Version 1.0
 */
public class Demo1144 {

    public int movesToMakeZigzag(int[] nums) {
        int[] s = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0], s[1]);
    }


    public static void main(String[] args) {
        int[] nums = new int[500];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 500; i++) {
            nums[i] = current.nextInt(1, 999);
        }
        int[] nums1 = {415, 936, 132, 825, 423, 679, 901, 83, 757, 496, 466};
//        System.out.println(Arrays.toString(nums));
        System.out.println(new Demo1144().movesToMakeZigzag(nums1));
    }
}
