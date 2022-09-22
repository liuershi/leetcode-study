package com.leetcode.bytedance;

import java.util.*;

/**
 * @author zhangwei151
 * @date 2022/9/20 0:06
 */
public class Demo698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;
        int target = sum / k;

        // 将nums倒叙排列，增加剪枝的可能性，降低回溯的次数
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        int[] bucket = new int[k];

        return traceBack(nums, 0, bucket, target);
    }

    private boolean traceBack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            // 说明：这里判断没有必要，由于是需要将所有的元素放进桶，而此时所有的元素肯定
            // 已经放入完毕，而每个bucket里面的值一定等于target，不存在某个桶的值不等于target
            /*for (int val : bucket) {
                if (val != target) return false;
            }*/
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            // 优化，当当前桶和前一个桶值相同时直接跳过
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            // 剪枝
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (traceBack(nums, index + 1, bucket, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new Demo698().canPartitionKSubsets(nums, k));
    }
}
