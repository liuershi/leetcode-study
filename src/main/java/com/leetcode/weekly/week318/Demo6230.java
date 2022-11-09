package com.leetcode.weekly.week318;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/11/6 10:45 上午
 * @Version 1.0
 */
public class Demo6230 {

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long rsp = 0, sum = 0;
        int right = 0;
        LinkedList<Integer> path = new LinkedList<>();
        int[] memo = new int[100001];
        while (right < n) {
            while (!path.isEmpty() && memo[nums[right]] != 0) {
                Integer val = path.removeFirst();
                sum -= val;
                memo[val]--;
            }
            if (path.size() < k) {
                path.addLast(nums[right]);
                memo[nums[right]]++;
                sum += nums[right];
            }
            if (path.size() == k) {
                rsp = Math.max(rsp, sum);
                Integer val = path.removeFirst();
                sum -= val;
                memo[val]--;
            }

            right++;
        }
        return rsp;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3));
    }
}
