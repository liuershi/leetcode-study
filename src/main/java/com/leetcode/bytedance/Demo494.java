package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/29 10:55 下午
 * @Version 1.0
 */
public class Demo494 {

    int res;
    public int findTargetSumWays(int[] nums, int target) {
        // 思路：回缩，查询所有可能的情况，判断是否累加和为目标值
        fallback(0, 0, nums, target);
        return res;
    }

    private void fallback(int index, int sum, int[] nums, int target) {
        if (index == nums.length) {
            if (sum == target) this.res++;
            return;
        }
        fallback(index + 1, sum + nums[index], nums, target);
        fallback(index + 1, sum - nums[index], nums, target);
    }


    /**
     * 思路二：动态规划
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysTwo(int[] nums, int target) {
        // 题目解析：我们可以把题目的需求等同于，找到nums中一个正子集P、一个负子集N，使得两个子集的和相加等于target
        // 例如：假设 nums = {1,2,3,4,5}, target = 3
        // 那么此时存在子集 P = {1,3,5} , 负子集 N = {2, 4}
        // 存在如下公式转换过程：
        //          sum(P) - sum(N) = target
        // sum(p) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
        //          2 * sum(P) = target + sum(nums)
        //          sum(p) = (target + sum(nums)) / 2
        // 最终，需求为找到数组nums中子数组和为 (target + sum(nums)) / 2 的情况
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 当和小于target或者sum + target为奇数时不可能存在符合的情况
        return sum < Math.abs(target) || (((sum + target) & 1) == 1) ? 0 : dp(nums, (sum + target) >>> 1);
    }

    private int dp(int[] nums, int val) {
        int[] dp = new int[val + 1];
        dp[0] = 1;
        for (int num : nums) {
            System.out.println(num);
            for (int i = val; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[val];
    }

    public static void main(String[] args) {
        Demo494 demo494 = new Demo494();
        int[] nums = {1,2,3,4,5};
        System.out.println(demo494.findTargetSumWaysTwo(nums, 5));
    }
}
