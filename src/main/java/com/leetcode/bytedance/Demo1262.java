package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/19 9:37 下午
 * @Version 1.0
 */
public class Demo1262 {

    public int maxSumDivThree(int[] nums) {
        int[] memo = new int[3];
        for (int num : nums) {
            int one = memo[0] + num;
            int two = memo[1] + num;
            int three = memo[2] + num;
            memo[one % 3] = Math.max(memo[one % 3], one);
            memo[two % 3] = Math.max(memo[two % 3], two);
            memo[three % 3] = Math.max(memo[three % 3], three);
        }
        return memo[0];
    }
}
