package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/19 10:46 下午
 * @Version 1.0
 */
public class Demo53 {

    public int maxSubArray(int[] nums) {
//        return method01(nums);

        // 方法二：使用动态规划
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int max = sums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sums[i - 1] >= 0) {
                sums[i] = sums[i - 1] + nums[i];
            } else {
                sums[i] = nums[i];
            }
            max = Math.max(max, sums[i]);
        }
        return max;
    }

    /**
     * 贪心算法
     *      事件复杂度：O(n)
     *      空间复杂度：O(1)
     * @param nums
     * @return
     */
    private int method01(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
