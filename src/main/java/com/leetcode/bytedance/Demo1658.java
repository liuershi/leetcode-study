package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/7 11:01 下午
 * @Version 1.0
 */
public class Demo1658 {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) return -1;
        int ans = -1, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right
                    ];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : nums.length - ans;
    }
}
