package com.leetcode.weekly.dipingxian.week308;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/28 10:36 上午
 * @Version 1.0
 */
public class Demo6160 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (queries[i] >= nums[j]) res[i] = j + 1;
                else break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo6160 demo6160 = new Demo6160();
        demo6160.answerQueries(new int[]{4,5,2,1}, new int[]{3, 10, 32});
    }
}
