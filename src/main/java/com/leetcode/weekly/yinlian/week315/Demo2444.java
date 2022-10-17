package com.leetcode.weekly.yinlian.week315;

/**
 * @Author milindeyu
 * @Date 2022/10/17 10:38 下午
 * @Version 1.0
 */
public class Demo2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long rsp = 0;
        // minK和maxK最近出现的下标
        int minI = -1, maxI = -1;
        // 最近不在minK和maxK范围内的数下标
        int lastIllegalRange = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) minI = i;
            if (nums[i] == maxK) maxI = i;
            if (nums[i] < minK || nums[i] > maxK) lastIllegalRange = i;
            rsp += Math.max(Math.min(minI, maxI) - lastIllegalRange, 0);
        }
        return rsp;
    }
}
