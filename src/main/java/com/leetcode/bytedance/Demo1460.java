package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/24 10:31 下午
 * @Version 1.0
 */
public class Demo1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 思路：只要两个数组中元素一样则一定可以通过翻转得到
//        return method1(target, arr);

        // 题意中，给定了每个元素的范围为 1 ～ 1000
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int[] nums = new int[1001];
        for (int val : target) {
            nums[val]++;
        }
        for (int val : arr) {
            if (--nums[val] < 0) return false;
        }
        return true;
    }

    private boolean method1(int[] target, int[] arr) {
        // 时间复杂度：nlogn + O(n)
        // 空间复杂度：O(1)
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) return false;
        }
        return true;
    }
}
