package com.leetcode.bytedance;


/**
 * 轮转数组
 *
 * @Author milindeyu
 * @Date 2022/7/28 10:00 下午
 * @Version 1.0
 */
public class Demo189 {

    public void rotate(int[] nums, int k) {
        // 反转三次数组
        // 分别是：
        // nums[0] ～ nums[nums.length - k - 1]
        // nums[nums.length - k] ~ nums[k]
        // nums[0] ~ nums[nums.length]

        // 当k大于数组长度是需转换下
        k %= nums.length;
        k = nums.length - k;
        if (k != 0) {
            reversal(nums, 0, k);
            reversal(nums, k, nums.length - 1);
            reversal(nums, 0, nums.length - 1);
        }
    }

    private void reversal(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
