package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/7/20 11:04 下午
 * @Version 1.0
 */
public class Demo918 {

    public int maxSubarraySumCircular(int[] nums) {
        // 思路：同找出数组中子数组最大值类似，区别在于在当前环形数组
        // 中，如果不是数组中间的子数组是最大，那么就是数组前半部分加
        // 上数组后半部分的和，而这部分的和，只需要用数组总和减去中间
        // 数组最小的和即可

        int total = 0, max = nums[0], curMax = 0, min = nums[0], curMin = 0;
        for (int num : nums) {
            total += num;
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }

    public static void main(String[] args) {
        Demo918 demo91 = new Demo918();
        int[] nums = {5,-2,5};
        System.out.println(demo91.maxSubarraySumCircular(nums));
    }
}
